package Algorithms.IntegerArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author Srinivas Vadige, srinivas.vadige@gmail.com
 * @since 23 Nov 2024
 */
public class MinimumNumberOfSwapsToSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 4, 7, 1, 5};
        arr = new int[]{2, 3, 4, 1, 5};
        System.out.println("minSwaps4: " + minSwaps4(arr));
        arr = new int[]{2, 3, 4, 1, 5};
        System.out.println("minSwaps5: " + minSwaps5(arr));
        arr = new int[]{2, 3, 4, 1, 5};
        System.out.println("minSwaps6: " + minSwaps6(arr));
        arr = new int[]{2, 3, 4, 1, 5};
        System.out.println("minSwaps7: " + minSwaps7(arr));
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static class Pair { // like python tuple
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private static int indexOf(int[] arr, int ele) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ele) {
                return i;
            }
        }
        return -1;
    }

    // only works for alternate series numbers
    public static int minSwapsForAlternate1(int[] arr) {
        int minSwaps = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                for (int j = i; j < arr.length; j++) {
                    if (arr[j] == i + 1) {
                        swap(arr, i, j);
                        minSwaps++;
                        break;
                    }
                }
            }
        }
        return minSwaps;
    }

    public static int minSwapsForAlternate2(int[] arr) {
        int minimumSwaps = 0;
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            while(current != i + 1){
                int temp = arr[current - 1];
                arr[current - 1] = current;
                arr[i] = temp;
                minimumSwaps++;
                current = temp;
            }
        }
        return minimumSwaps;
    }

    public static int minSwapsForAlternate3(int[] arr) {
        int i = 0;
        int swap = 0;
        while( i < arr.length ) {
            if (arr[i] == i+1)
            i += 1;
            else{
                int index = arr[i] -1;
                swap(arr, i, index);
                swap += 1;

            }
        }
        return swap;
    }

    public static int minSwapsForAlternate4(int[] arr) {
        boolean arr_sorted = false;
        int current_pointer = 0;
        int swaps = 0;

        while (!arr_sorted) {
            if (current_pointer == arr.length) {
                arr_sorted = true;
                break;
            }

            if (current_pointer+1 == arr[current_pointer])
                current_pointer += 1;
            else {
                int ind = arr[current_pointer] - 1;
                swap(arr, current_pointer, ind);
                swaps += 1;
            }
        }

        return swaps;
    }

    /**
     * @TimeComplexity O(nlogn)
     */
    public static int minSwaps4(int[] arr) {
        int n = arr.length;

        // Create two arrays and
        // use as pairs where first
        // array is element and second array
        // is position of first element
        ArrayList<Pair> arrPos
            = new ArrayList<Pair>();
        for (int i = 0; i < n; i++)
            arrPos.add(new Pair(arr[i], i));

        // Sort the array by array element values to
        // get right position of every element as the
        // elements of second array.
        arrPos.sort( new Comparator<Pair>() {
            @Override
            public int compare( Pair o1, Pair o2) {
                if (o1.first < o2.first)
                    return -1;

                // We can change this to make
                // it then look at the
                // words alphabetical order
                else if (o1.first == o2.first)
                    return 0;

                else
                    return 1;
            }
        });

        // To keep track of visited elements. Initialize
        // all elements as not visited or false.
        Boolean[] vis = new Boolean[n];
        Arrays.fill(vis, false);

        // Initialize result
        int ans = 0;

        // Traverse array elements
        for (int i = 0; i < n; i++) {
            // already swapped and corrected or
            // already present at correct pos
            if (vis[i] || arrPos.get(i).second == i)
                continue;

            // find out the number of  node in
            // this cycle and add in ans
            int cycle_size = 0;
            int j = i;
            while (!vis[j]) {
                vis[j] = true;

                // move to next node
                j = arrPos.get(j).second;
                cycle_size++;
            }

            // Update answer by adding current cycle.
            if (cycle_size > 0) {
                ans += (cycle_size - 1);
            }
        }

        // Return result
        return ans;
    }

    /**
     * @TimeComplexity O(nlogn)
     */
    public static int minSwaps5(int[] nums) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++)
            map.put(nums[i], i);

        Arrays.sort(nums);

        // To keep track of visited elements. Initialize
        // all elements as not visited or false.
        boolean[] visited = new boolean[len];
        Arrays.fill(visited, false);

        // Initialize result
        int ans = 0;
        for (int i = 0; i < len; i++) {

            // already swapped and corrected or
            // already present at correct pos
            if (visited[i] || map.get(nums[i]) == i)
                continue;

            int j = i, cycle_size = 0;
            while (!visited[j]) {
                visited[j] = true;

                // move to next node
                j = map.get(nums[j]);
                cycle_size++;
            }

            // Update answer by adding current cycle.
            if (cycle_size > 0) {
                ans += (cycle_size - 1);
            }
        }
        return ans;
    }

    /**
     * @TimeComplexity: O(N^2)
     */
    public static int minSwaps6(int[] arr) {
        int ans = 0;
        int N = arr.length;
        int[] temp = Arrays.copyOfRange(arr, 0, N);
        Arrays.sort(temp);
        for (int i = 0; i < N; i++) {

            // This is checking whether
            // the current element is
            // at the right place or not
            if (arr[i] != temp[i]) {
                ans++;

                // Swap the current element
                // with the right index
                // so that arr[0] to arr[i] is sorted
                swap(arr, i, indexOf(arr, temp[i]));
            }
        }
        return ans;
    }

    /**
     * @TimeComplexity O(nlogn)
    */
    public static int minSwaps7(int[] arr) {
        int ans = 0;
        int N = arr.length;
        int[] temp = Arrays.copyOfRange(arr, 0, N);

        // Hashmap which stores the
        // indexes of the input array
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();

        Arrays.sort(temp);
        for (int i = 0; i < N; i++) {
            h.put(arr[i], i);
        }
        for (int i = 0; i < N; i++) {

            // This is checking whether
            // the current element is
            // at the right place or not
            if (arr[i] != temp[i]) {
                ans++;
                int init = arr[i];

                // If not, swap this element
                // with the index of the
                // element which should come here
                swap(arr, i, h.get(temp[i]));

                // Update the indexes in
                // the hashmap accordingly
                h.put(init, h.get(temp[i]));
                h.put(temp[i], i);
            }
        }
        return ans;
    }
}
