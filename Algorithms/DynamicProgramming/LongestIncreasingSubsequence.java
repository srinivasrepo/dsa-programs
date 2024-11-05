package Algorithms.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * Given an array of integers nums, return the length of the longest
 * increasing subsequence.
 *
 * A subsequence is a sequence that can be derived from an array
 * by deleting some or no elements without changing the order of the remaining elements.
 *
 * nums = {1, 2, 4, 3}
 *
 *  initial sequence -->                                     {}
 *                        ____________________________________|____________________________
 *                        |                                  |                  |          |
 *  start sequence -->  i0 {1}                             i1 {2}             i2 {4}     i3 {3}
 *         _______________|________________        __________|______            |
 *         |              |                |       |                |          {4,3} ❌
 *     i1 {1, 2}      i2 {1, 4}        i3 {1, 3}    {2,4}            {2,3}
 *     _____|_______      |{1,4,3} ❌                 |
 *     |           |                             {2,4,3} ❌
 *  {1, 2, 4}    {1, 2, 3}
 *     |
 *  {1, 2, 4, 3} ❌
 *
 * i.e we have to make what will be the next element in each and every sequence in increasing order
 * Here it looks like a tree (not a binary tree) and non-fixed child notes length - but max child nodes is (i to n-1)
 * i.e for {1} the nodes are {1, 2}, {1, 3} and {1, 4} and looks like the width of the child is always less than parent
 *
 * we don't need to calculate i1 {2} i.e "index 1" scenario again cause we already have at i0 {1}'s child i.e i1 {1,2} "index 1"
 * So, don't calculate same index again
 *
 * So, from the graph we need the max valid depth i.e dfs
 *
 * SOLUTION:
 * 1. Calculate from right to left and save it in dp. Eg: so that we can use index 1 scenario from {2} in index 1 scenario in {1,2}
 * 2.
 *
 * </pre>
 * @author Srinivas Vadige, srinivas.vadige@gmail.com
 * @since 03 Nov 2024
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 3};
        System.out.println(lengthOfLIS(nums));
        System.out.println(lengthOfLIS2(nums));
    }

        /**
     * Brute Force but we use previously calculated LIS
     * @TimeComplexity O(n^2)
     * @SpaceComplexity O(n)
     */
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] LIS = new int[n]; // Longest Increasing Subsequence for each index
        Arrays.fill(LIS, 1);

        for (int i = n-1; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                if (nums[i] < nums[j])
                    LIS[i] = Math.max(LIS[i], 1+LIS[j]); // we already calculated LIS[j] and +1 for LIS length increment
            // but we have to check the next all ints too cause we might get something like {1, 2, 5, 3, 4} -> {1, 2, 3, 4} is LIS
            // and by using max() we only taking the max of all possibilities
            // Eg: LIS[1] = Math.max(LIS[1], 1+LIS[2], 1+LIS[3], 1+LIS[4]); i.e max of all possibilities sub indices
            // and so we're avoiding n^3 or more graph traversals using max() and dp[]
            }
        }

        return Arrays.stream(LIS).max().getAsInt();
    }

    /**
     * Brute Force
     * @TimeComplexity O(n^2)
     * @SpaceComplexity O(n)
     */
    public static int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (nums[j] < nums[i]) // we're skipping for == and > scenarios
                    dp[i] = Math.max(dp[i], dp[j]); // or Math.max(LIS[i], 1+LIS[j]);
            }
            dp[i]++; // skip this if we used Math.max(LIS[i], 1+LIS[j]);
        }

        return Arrays.stream(dp).max().getAsInt();
    }


    public int lengthOfLISLowerBound(int[] a) {
        List<Integer> lis = new ArrayList<>();

        for (Integer elem : a) {
            if (lis.isEmpty() || lis.get(lis.size()-1) < elem) {
                lis.add(elem);
            } else {
                int lowerBoundPos = lowerBound(lis, elem);
                lis.set(lowerBoundPos, elem);
            }
        }
        return lis.size();
    }

    private int lowerBound(List<Integer> lis, int elem) {
        int l = 0;
        int r = lis.size();

        while (l<=r) {
            int mid = l + (r-l)/2;
            if (lis.get(mid) == elem) return mid;
            else if (lis.get(mid) > elem) r = mid-1;
            else l = mid+1;
        }
        return l;
    }






    public int lengthOfLISDpMatrix(int[] nums) {
        int last=-1;
        int dp[][] =new int[nums.length+2][nums.length+1];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(nums, last, 0, dp);
    }

    int solve(int nums[], int lastIndex, int i, int[][] dp) {

        if(i >= nums.length){
            return 0;
        }

        if(dp[lastIndex+1][i] != -1){
            return dp[lastIndex+1][i];
        }

        int inc=0, exc=0;
        int curr = nums[i];

        if(lastIndex == -1 || curr > nums[lastIndex]){
            inc = 1+solve(nums, i, i+1, dp);
        }

        exc = solve(nums, lastIndex, i+1, dp);

        dp[lastIndex+1][i] = Math.max(inc, exc);
        return dp[lastIndex+1][i];
    }


    // NOT WORKING
    public static int lengthOfLISbDp(int[] nums) {
        int[] dp = new int[nums.length];
        dp[dp.length-1] = 1;

        for (int i = nums.length-2; i>=0; i--){
            rec(i, nums, dp, 0);
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    private static int rec(int i, int[] nums, int[] dp, int tempSum) {
        if(i < 0) return 0;

        if (dp[i] > 0) return dp[i];

        if ( nums[i] < nums[i+1] ) {
            tempSum += 1+rec(i-1, nums, dp, tempSum);
        }
        else if(nums[i] == nums[i+1]){

        }

        return i;
    }


    // won't work as we can't change the index position of the number
    public int lengthOfLIS_UsingSort(int[] nums) {

        Arrays.sort(nums); // won't work

        // skip dups

        List<Integer> list = new ArrayList<>();

        List<Integer> tempList = new ArrayList<>();
        tempList.add(nums[0]);
        for(int i=1; i<nums.length; i++){
            if(tempList.get(tempList.size()-1) > nums[i]){
                tempList.clear();
                tempList.add(nums[i]);
            } else if(tempList.get(tempList.size()-1) == nums[i]){
                continue;
            } else {
                tempList.add(nums[i]);
            }

            if(tempList.size() > list.size()){
                list.clear();
                list.addAll(tempList);
            }

            System.out.println("tempList " + tempList);
            System.out.println("list " + list);
        }

        return list.size();
    }

}
