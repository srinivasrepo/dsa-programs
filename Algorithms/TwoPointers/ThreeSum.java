package Algorithms.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The sum of three integers a + b + c = 0
 * Find all unique triplets in the array which gives the sum of zero.
 * 
 * <p>Note:
 * 
 * 1. The solution set must not contain duplicate triplets.
 * 
 * <p> we achieve O(n) time complexity. It's ok to solve it with O(n^2) sorting or hashmap and
 * 
 * OBSERVATIONS:
 * 1. In [-3, 3, 1, 2, 3, 4]. We already calculated all possible sums for -3 in 0th index then skip the -3 in 1st index
 * 2. And if we sorted the array then we can increment and decrement the pointers based on the sum i.e sum > 0 move the right-- and sum < 0 move the left++
 * 
 * @author : Srinivas Vadige
 * @since : 01 Oct 2024
 */
public class ThreeSum {
    
    
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSumWithSort(nums));
        System.out.println(threeSumWithSortAndHashMap(nums));
    }

    
    /**
     * Time Complexity = O(n^2) + O(n log n) = O(n^2)
     * use sorting
     * so after the sort,  [-1,0,1,2,-1,-4] will be converted to [-4,-1,-1,0,1,2]
     */
    private static List<List<Integer>> threeSumWithSort(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) // skip if the i num if it is same as previous num, as we already calculated its all possibilities and we don't want duplicates
                continue;
            int j = i + 1, k = nums.length - 1; // i is left most pointer, j is i's next num and k right most pointer
            while (j < k) { // middle and right pointer
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) { // as arr is sorted
                    j++;
                } else if (sum > 0) {
                    k--;
                } else { // == 0
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) j++; // for duplicates like [-2, -2, 0, 0, 2, 2]
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--; // as we used up both j and k, decrease the window
                }
            }
        }
        return list;
    }

            /**
         * Time Complexity: O(n^2)
         */
        public static List<List<Integer>> threeSumWithSortAndHashMap(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();
    
            for (int i = 0; i < nums.length - 1; i++) {
                map.clear();
                for (int j = i + 1; j < nums.length; j++) {
                    int complement = -nums[i] - nums[j];
                    if (map.containsKey(complement)) { // add to list only if complement is present in map and we are not getting any data from map. Just add and check it's present in map or not
                        List<Integer> triplet = Arrays.asList(nums[i], complement, nums[j]);
                        Collections.sort(triplet);
                        if (!result.contains(triplet)) {
                            result.add(triplet);
                        }
                    }
                    map.put(nums[j], j);
                }
            }
            return result;
        }
    
    
    /**
     * Time Complexity = O(n^2) + O(n log n) = O(n^2)
     * use sorting
     */
    public static List<List<Integer>> threeSumWithSort2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int total = nums[i] + nums[j] + nums[k];

                if (total > 0) {
                    k--;
                } else if (total < 0) {
                    j++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;

                    while (nums[j] == nums[j-1] && j < k) {
                        j++;
                    }
                }
            }
        }
        return res;        
    }
    public static List<List<Integer>> threeSumBruteFroce(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return list;

    }

    /**
     * 
     * My thoughts on achieving < O(n^2)
     * 
     */
    public List<List<Integer>> threeSum2
    (int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List< List<Integer> > list = new ArrayList<>();

        int l = 0, r = nums.length-1;

        for(Integer i=0; i<nums.length; i++){
            List<Integer> tempList = map.getOrDefault(nums[i], new ArrayList<>() );
            tempList.add(i);
            map.put(nums[i], tempList);
        }

        System.out.println(map);

        while(l<nums.length){

            for(r=l+1; r<nums.length; r++){

            
            Integer need = -( nums[l] + nums[r] );

            List<Integer> subList = new ArrayList<>( Arrays.asList(nums[l], need, nums[r] ));
            Collections.sort(subList); 
            
            boolean isMatched = false;
            if(map.containsKey(need)){            
                for (Integer i: map.get(need)){
                    if (i==l || i==r)
                        isMatched = true;
                }
            }
            if( map.containsKey(need) && list.contains(subList)  && !isMatched)  {
            
                list.add(subList);
            }

            System.out.println("need:"+need+ " , l num:" +nums[l]+ " , r num:" + nums[r]);
             
            }
            l++;
        }


        return list;
    }
}
