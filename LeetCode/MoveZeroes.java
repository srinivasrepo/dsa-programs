package LeetCode;

import java.util.*;
import java.util.stream.*;

public class MoveZeroes {
    public static void main(String[] args) {

        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    // keep left pointer in 1st 0 num index
    public static void moveZeroes(int[] nums) {
        int left = 0;
        
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
        }

    }

    // to avoid self swap untill we find 0 num index
    public static void moveZeroesEnhanced(int[] nums) {
        int left = -1;
        for (int i = 0; i < nums.length; i++) { // move 
            if(nums[i] == 0) {
                left = i;
                break;
            }
        }
        if (left == -1) return;
        
        for (int right = left+1; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
        }

    }

    // brute force with ===0
    public static void moveZeroesBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - 1] = 0;
            }
        }
    }

    // using list
    public static void moveZeroesList(int[] nums) {

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                list.add(0);
            }
        }

        List<Integer> nonZeroList = new ArrayList<Integer>();

        nonZeroList = IntStream.of(nums).filter(n -> n != 0).boxed().collect(Collectors.toList());

        nums = nonZeroList.stream().mapToInt(i -> i).toArray();
    }
}
