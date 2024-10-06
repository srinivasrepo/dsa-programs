package Algorithms.PrefixSum;

import java.util.HashMap;
import java.util.Map;
/**<pre>
 * @author Srinivas Vadige,
 * @since 25 Sept 2024,
 */
public class ContigousBinaryArray {

    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0,1,0}));
    }


    public static int findMaxLength(int[] nums) {
    
        int prefixSum = 0;
        int maxLength = 0;

        Map<Integer, Integer> sumsMap = new HashMap<>();
        // sumsMap.put(null, null)
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i] == 0 ? -1 : nums[i];

            prefixSum += num;

            if(prefixSum == 0 && maxLength < i+1){
                maxLength = i+1; // +1 as i is index
            }

            if(sumsMap.containsKey(prefixSum) && i - sumsMap.get(prefixSum) > maxLength){ // current sum is in map
                maxLength = i - sumsMap.get(prefixSum);
            }

            if(!sumsMap.containsKey(prefixSum))
                sumsMap.put(prefixSum, i);
    
        }
        
        return maxLength;
    }
    
}
