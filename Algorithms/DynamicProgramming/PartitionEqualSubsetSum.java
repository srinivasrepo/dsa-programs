package Algorithms.DynamicProgramming;

import java.util.Arrays;

/**
 * <pre>
 * sum of all elements = 2 *( 1 sub array sum )
 *
 * loop up to (sum/2) calculate
 *
 * same like coin change --- but limited coins
 *
 * can't repeat same index
 * don't care about subArrays lens
 *
 * [1,5,11,5]
 *
 * sum = 22
 * target = 11
 * Contiguous SubsSequence array i.e don't take prev indices in the subArray. So, last ele in suArray has to has child nodes with next index elements
 * So, child nodes of current node will always be less than parent
 *
 *                                                                                      [] sum=0 need=11
 *                                            ___________________________________________|___________________________________________
 *                                            |                                          |                          |                |
 *                                           [1] s=1 n=10                         [5] s=5 n=6                     [11]              [5]
 *                   _________________________|______________________________            |                          |                |
 *                  |                         |                            |
 *                 [1,5] s=6 n=5             [1,11] s=16 n=5             [1,5] s=6 n=5
 *      ____________|                         |
 *     |            |                        [1,11,5]
 *    [1,5,11]     [1,5,5]
 *    s=17 n=-6    s=11 n=0
 *     ❌           ✅
 *
 * If we got one targetSum from one subArray sum, We already know that the other subArray sum must be 11. because the total sum of the given array is 22.
 *
 * </pre>
 * @author Srinivas Vadige, srinivas.vadige@gmail.com
 * @since 05 Nov 2024
 */
public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) return false; else sum/=2;

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[sum];
    }





    // If we can have a best solution for Sum of Non Contiguous SubArray then we can return true if we found "sub-array sum equals to given array sum/2"

}
