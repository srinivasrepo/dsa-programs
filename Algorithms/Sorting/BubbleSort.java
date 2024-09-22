package Algorithms.Sorting;
import java.util.Arrays;

/**
* @author Srinvas Vadige 
* @since 21 Sept 2014
*/
public class BubbleSort { // compares "adjacent pairs"; j=0 and compare j & j+1 and sort <- from right to left

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{3, 2, 4, -1, 1000, 100, 3, 1})));
    }

    // length-i-1; -1 cause we use both items[j+1] & items[j]
    // and -i cause last items already been sorted. So, -i is optional & we add this to make less iterations
    public static int[] sort(int[] items){
        for(int i=0; i<items.length; i++){
            for(int j=0; j<items.length-i-1; j++){ 
                int jItem = items[j];
                int jNextItem = items[j+1];
                System.out.println(Arrays.toString(items));
                if(jNextItem < jItem){ // or keep the current j+1 index in temp and swap at last loop
                    int temp = items[j];
                    items[j] = items[j+1];
                    items[j+1] = temp;
                }

            }
        }

        return items;
    }
    
}
