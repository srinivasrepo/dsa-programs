package Algorithms.Sorting;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * using PIVOT and take all ieft array items less than pivot and right as greater than pivot
 * same like merge sort + binary sort middleIndex, it is recursive alogorithm, divide pivot and two left and right subarrays, then again each of these sub arrays again be divided into a pivot (of sub-array) and 2 sub-arrays (of sub-array) and so on.
* @author Srinvas Vadige 
* @since 21 Sept 2024
*/
public class QuickSort{ 
    public static void main(String[] args) {
        int len = 10;
        int[] items = new int[len];
        for (int i = 0; i < len; i++) {
            items[i] = new Random().nextInt(0,len+1);
        }
        System.out.println("Array before sort: \n" + Arrays.toString(items) + "\n");

        getCurrentTimeStamp();
        sort(items, 0, items.length-1);
        getCurrentTimeStamp();
        
        System.out.println("\nArray after sort: \n" + Arrays.toString(items));

    }

    // low and high are default params
    public static void sort(int[] items, int low, int high){

        System.out.println(String.format("--------- sort(low:%s, high: %s) ---------", low, high));

        if (low >= high ) return;

        // ---------- at beginning condider that no small element in 0 index. so start i less than 0 ----------
        int i = low-1; //and int j = low;
        // pivot can be anything but to be consistent all over the recursions, take the last elemnt of the array or sub-array
        int pivot = items[high];

        // ------------ MOVE SMALLER THAN PIVOT VALS TO LEFT ---------------
        // Do 2 operations when you find the j pointer element is smaller than pivot
		// Operation 1: increment i index i.e i++
		// Operation 2: swap i&j elements
		// i.e moving all pivot small values to left of the fist big num.
		// therefore first big number index is always i+1;
        for (int j = low; j <= high; j++) {
            if (items[j] < pivot) {
                i++;
                swap(items, i, j);
                System.out.println("\nincremented i from "+ (i-1) + " to " + i +" and swaped(i:" +i+ " and j: "+j+")");
            } else System.out.println("\nSkipping");

            System.out.println("Array at j= " + j + " is: " + Arrays.toString(items));
        }
        // swapping pivot to starting big num index i.e last small num index i + 1;
		// new pivot index value => i+1
        swap(items, i+1, high);
        System.out.println("\nArray at new pivot " + (i+1) + " is: " + Arrays.toString(items) + "\n");

        // skip the i+1 => index current pivot value by skipping the new pivot index
        System.out.println("\nnext childs are");
		System.out.println(low + "," + i);
		System.out.println(i+2 + "," + high);
        sort(items, low, i);
        sort(items, i+2, high);
    }


    static void swap(int[] items, int a, int b){
        int temp = items[a];
        items[a]=items[b];
        items[b]=temp;
    }


    public static void getCurrentTimeStamp() {
    System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
}
    

}