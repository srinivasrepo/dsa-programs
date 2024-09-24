package LeetCode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
* @author Srinvas Vadige 
* @since 21 Sept 2014
*/
public class TwoSum {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        int target = 5;
        System.out.println(Arrays.toString(twoSumBruteForce(arr, target)));
        System.out.println(Arrays.toString(twoSumOnePassHashMap(arr, target)));
        System.out.println(Arrays.toString(twoSumTwoPassHashMap(arr, target)));
    }

    /**
     * Time Complexity = O(n^2)
    */
    public static int[] twoSumBruteForce(int[] nums, int target) {
        int[] res = new int[2];
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]+nums[j] == target){
                    return res = new int[]{i,j}; // or assign res & break; or just return new int[]{i,j} & return new int[] at method end line;
                }                    
            }
        }
       return res;
    }

    /**
    * Time Complexity = O(n)
    */
    public static int[] twoSumOnePassHashMap(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int [] ans = new int[2];
        int n = nums.length;
        for(int i=0; i<n; i++) {
            int partner = target - nums[i];
            if(hm.containsKey(partner)) {
                ans[0] = hm.get(partner); // new int[]{numMap.get(complement), i};
                ans[1] = i;
                break;
            }
            hm.put(nums[i], i);
        }
        return ans;
    }

    public static int[] twoSumTwoPassHashMap(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        // Build the hash table
        for (int i = 0; i < n; i++) {
            numMap.put(nums[i], i);
        }

        // Find the complement
        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement) && numMap.get(complement) != i) {
                return new int[]{i, numMap.get(complement)};
            }
        }

        return new int[]{}; // No solution found
    }
    
}
