package Algorithms.Sorting;

/**
* @author Srinvas Vadige, srinivas.vadige@gmail.com
* @since 21 Sept 2024
*/
import java.util.Arrays;

// instead of swapping we do shifting(copy)
// i.e make a copy of j val in next right side index i.e we have two same values here until we shift the original copy with much more smaller value from left
// FIRST FOR i LOOP MOVES FROM LEFT TO RIGHT
// AND SECOND WHILE j LOOP MOVES FROM RIGHT TO LEFT i.e j always < i and max val of j+1 is i.

public class InsertionSort {

    public static void main(String[] args) {
        int[] items = new int[]{3, 2, 4, -1, 1000, 100, 3, 1};
        sort(items);
        System.out.println(Arrays.toString(items));
    }

    // assume that 1st value is always sorted. so, start "i for loop" with 1st index
    // and now we call this ith or 1st index val as 'key' variable (ith val copy is in temp "key" var)
    // and inside this "i for loop" create a "j = i-1" variable i.e j=0 at the starting of for loop
    // second while loop iterates up to "j = (-1) or (original copy of small lefty index-1)" && checks if key is smaller than lefties in each while loop
    // j is less than "0 or original copy of small lefty index" cause in while loop we use j-- in last loop as well
    // In this while loop condition, shift the lefties to one step to right as long as this key is smaller (make copy of the original lefty to right side)
    // as we're shifting j(left) index value to j+1(right), j won't change i.e original copy will be their until we shift again
    // now after whole while loop, repalce the j="(-1+1 val) or (original copy of small lefty val)" with our key
    // to put it simply => arrange key in left side
    public static void sort(int[] items){

        for(int i=1; i<items.length; i++){
            int key = items[i]; // temp variable
            int j=i-1;

            while (j>=0 && items[j]>key) { // is key is smaller than lefty
                items[j+1] = items[j]; // make a copy i.e now we have two same value => original and copy
                j--; // right to left
            }

            items[j+1] = key; // replace original with key temp variable
        }
    }

}
