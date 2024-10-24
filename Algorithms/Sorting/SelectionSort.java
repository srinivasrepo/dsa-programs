package Algorithms.Sorting;
import java.util.Arrays;

/**
* @author Srinvas Vadige, srinivas.vadige@gmail.com
* @since 21 Sept 2024
*/
public class SelectionSort { // Select from left to right; j=i+1

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{3, 2, 4, -1, 1000, 100, 3, 1})));
    }

     // keep the current left item constant and slide every right side items one by one
    public static int[] sort(int[] items){
        for(int i=0; i<items.length; i++){
            for(int j=i+1; j<items.length; j++){
                int iItem = items[i];
                int jItem = items[j];
                if(jItem < iItem){ //swap every time or store the smallest item index and 'swap at last j'
                    int temp = items[i];
                    items[i] = items[j];
                    items[j] = temp;
                }
            }
        }
        return items;
    }
}
