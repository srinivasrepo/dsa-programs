package Algorithms.Hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 You must write an algorithm that runs in O(n) time.
 * 
 * 
 * @author Srinvas Vadige 
 * @since 24 Sept 2014
 */
public class LongestConsecutiveSequence {
    
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
        System.out.println(longestConsecutive2(nums));
    }

    // Time Complexity = O(n log n) cause we are sorting the array
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums));
        int tempMax = 1;
        int maxFinal = 1;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (prev == nums[i]) {
                continue;
            } else if (prev + 1 == nums[i]) {
                tempMax++;
                if (tempMax > maxFinal)
                    maxFinal = tempMax;
            } else
                tempMax = 1;
            prev = nums[i];
        }
        return maxFinal;
    }

    // Time Complexity = O(n) using set
    public static int longestConsecutive2(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;

        for (int num : nums) {
            if (!numSet.contains(num - 1)) {
                int length = 1;

                while (numSet.contains(num + length)) {
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;        
    }
}
