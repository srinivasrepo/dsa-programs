package Algorithms.DynamicProgramming;

/**
 * <pre>
 * [2,7,9,3,1] -> Max of [2,0,9,0,1] and [0,7,0,3,0]
 * or can we skip more that 1 house?
 * [2,1,1,2] -- it's 4
 * so, two cases -> skip 1 or skip 2 that's how we can cover all big houses
 * no need to skip 3 or 4 houses as we include them in skip 1, skip 2 scenario
 * top down memo dp ---> Math.max(n-2, n-3) and base case? i < 0 => 0
 * save in dp
 * </pre>
 * @author Srinivas Vadige, srinivas.vadige@gmail.com
 * @since 29 Oct 2024
 */
public class HouseRobber {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};
        System.out.println("robBottomUpNoMemory: " + robBottomUpNoMemory(nums));
        System.out.println("robBottomUpTabulation: " + robBottomUpTabulation(nums));
        System.out.println("robTopDownMemo: " + robTopDownMemo(nums));
    }

    public static int robBottomUpNoMemory(int[] nums) {
        int prev = 0;
        int curr = 0;
        int next = 0;
        for (int n : nums) {
            next = Math.max(prev + n, curr);
            prev = curr;
            curr = next;
        }
        return curr;
    }

    public static int robBottomUpTabulation(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 0 || nums == null) return 0;

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    public static int robTopDownMemo(int[] nums) {
        Integer[] dp = new Integer[nums.length]; // we use int[] instead of Integer[] because we can have [0,0,0,0] as input or initialize int[] and loop & set -1

        int max = rec(0, nums, dp);
        if(nums.length > 1) max = Math.max(rec(1, nums, dp), max);

        return max;
    }

    private static int rec(int i, int[] nums, Integer[] dp) {

        if(i >= nums.length) return 0;
        if (dp[i] != null) return dp[i];

        dp[i] = nums[i] + Math.max(rec(i+2, nums, dp), rec(i+3, nums, dp));

        System.out.println(dp[i] + " <= (" + ((i+2)>=nums.length?0:dp[i+2]) + " or " + ((i+3)>=nums.length?0:dp[i+3]) + ") + " +  nums[i]);

        return dp[i];
    }
}
