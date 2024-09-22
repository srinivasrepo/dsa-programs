package Algorithms.Sorting;

/**
* @author Srinvas Vadige 
* @since 21 Sept 2014
*/
import java.util.Arrays;

// take the middle item, divide the into 2 sublists(0 to m and m to length) and continue so on
// recursion function and update the inputArr and it's sub halfs using pass by reference
public class MergeSort { 

    
    public static void main(String[] args) {
        int[] inputArr = new int[]{3, 2, 4, -1, 1000, 100, 3, 1, 0};
        System.out.println("------------------ Before sorting: " + Arrays.toString(inputArr));
        sort(inputArr);
        System.out.println("------------------ After sorting: " + Arrays.toString(inputArr));
    }

    
    public static void sort(int[] inputArr){

        // -------- DIVIDE ---------    

        // no need to divide [e] or [] again into two halfs
        if(inputArr.length < 2) return;

        // divide input array into 2 halfs using middle index
        int midIndex = inputArr.length/2;
        int[] leftHalf = Arrays.copyOfRange(inputArr, 0, midIndex); // or use for loop leftHalf[i]=inputArr[i] or System.arraycopy or IntStream
        int[] rightHalf = Arrays.copyOfRange(inputArr, midIndex, inputArr.length); // or use for loop rightHalf[i-midIndex]=inputArr[i]
        System.out.println("DIVIDING input array: " + Arrays.toString(inputArr)  + ", length: " + inputArr.length + " INTO TWO HALFS => " + "  leftHalf array: " + Arrays.toString(leftHalf) + ", length: " + leftHalf.length + "  rightHalf array: " + Arrays.toString(rightHalf) + ", length: " + rightHalf.length);

        // now again divide these sub half arrays into more two halfs using recursion untill single element array
        sort(leftHalf);
        sort(rightHalf);


        // --------- CONQUER / MERGE ----------
        // update the inputArr by comparing each elements with sub arrays (nested recusion left & right halfs becomes [e1] [e2] then start comparing with merge() method )
        // we can use extra method and update inputArr using "pass by reference" (extra method is optional) 
        merge(inputArr, leftHalf, rightHalf);
        System.out.println("==========> inputArr after sorting => " + Arrays.toString(inputArr));
    }
    
    static void merge(int[] inputArr, int[] leftHalf, int[] rightHalf){
    
        // ----- loop leftHalf and rightHalf at once using while loop ----

        // left, right, input arrays indexes
        int i=0, j=0, k=0;
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        // compare each left and right half elements and update the inputArr
        // we don't care about the previous values in inputArr, we just want that array length to be the sum of leftSize and rightSize
        // this while loop exits when i == leftSize or j == rightSize i.e we can't complete all the i or j values here
        // cause when inputArr[1,8,5] => unsorted in current recursion leftHalf[1,8] rightHalf[5]  => sorted after child recusrion leftHalf[1,8] rightHalf[5] === after while loop ===> current recursion inputArr[1,5,5] i=1,j=1,k=1 but we need i to be 2 that means all i elements completed
        // or inputArr[1,0,9,8] => leftHalf[1,0] rightHalf[9,8] => leftHalf[0,1] rightHalf[8,9] ======> inputArr[0,1,9,8] i=2,j=0,k=2
        // i.e always only one sub half failed to increase index value upto it's length
        while (i<leftSize && j<rightSize) {
            if (leftHalf[i] <= rightHalf[j]) {
                inputArr[k] = leftHalf[i];
                i++;
            } else {
                inputArr[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        // now, here complete all (i and k) or (j and k) values to it's array length using while(i<leftSize) and while(j<rightSize)
        while (i<leftSize) {
            inputArr[k] = leftHalf[i];
            i++;k++;
        }
        while (j<rightSize) {
            inputArr[k]=rightHalf[j];
            j++;k++;
        }
    }
    
}
