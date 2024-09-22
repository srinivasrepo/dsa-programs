package LeetCode;
import java.util.Arrays;

/**
* @author Srinvas Vadige 
* @since 21 Sept 2014
*/
public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1,2,3,4,5}, 5)));
    }

    public static int[] twoSum(int[] nums, int target) {
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
    
}
