package Algorithms.DynamicProgramming;


/**
 * Can only move 1 step or 2 steps at a time
 * 
 * 

                                                 n=5
                                    4_____________|________________3
                         3__________|__________2         2_________|_______1
               2_________|_____1           1___|___0  1___|___0
       1_______|______0      0  -1       0  -1            
                               
                          
    how many times we got 1?

    no memo --- as we need all cases i.e min and max

    rec backtracking ---- TLE -> memo?? 

    => we already know 

    ways for reaching 1  =>
    3,2,1
    3,1
    
    so, from 3 we can see that it has two ways --> memo the ways??

    imagine 3 as a graph
 * 
 * 
 * 
 * 
 * @author Srinvas Vadige
 * @since 15 Oct 2024
 */
public class ClimbingStairs {
    
    public static void main(String[] args) {
        System.out.println("climbStairsBottomUpTabulationDp: " + climbStairsBottomUpTabulationDp(5));
        System.out.println("climbStairsTopDownMemoDp: " + climbStairsTopDownMemoDp(5));
        System.out.println("climbStairsUsingRecurseBacktracking: " + climbStairsUsingRecurseBacktracking(5));
    }

    /**
     * @Time Complexity: O(n)
     * @Space Complexity: O(n+1) // for O(n) use if condition to return 1 in the base case
     */    
    public static int climbStairsBottomUpTabulationDp(int n) {
        int[] dp = new int[n+1]; // n+1 because dp[n] will work for n and will also work for n-2 logic
        dp[0] = 1; // cause from 2 we can like 1,1 or 2,1 i.e 2 ways i.e n-1, n-1 or n-2, 0
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairsBottomUpNoMemoryDp(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int prev = 1, curr = 1;
        for (int i = 2; i <= n; i++) {
            int temp = curr;
            curr = prev + curr;
            prev = temp;
        }
        return curr;
    }



    /**
     * @Time Complexity: O(n)
     * @Space Complexity: O(n)
     */
    public static int climbStairsTopDownMemoDp(int n) {
        int[] dp = new int[n];
        return rec(n, dp);
    }
    public static int rec(int n, int[] dp){
        if(n < 0) return 0; //bc
        else if(n==0) return 1;
        if(dp[n-1] !=0 ) return dp[n-1]; // -1 dp length is n. So, save from n-1 to 0 or n to 1 by setting dp length ti n+1        
        return dp[n-1] = rec(n-1, dp) + rec(n-2, dp);
    }



    /**
     * Got TLE in LeetCode
     * 
     * @Time Complexity: O(2^n)
     * @Space Complexity: O(1)
     */
    public static int climbStairsUsingRecurseBacktracking(int n) {
        int[] dp = new int[1];
        rec2(n, dp);
        return dp[0];
    }
    public static void rec2(int n, int[] dp){
        if(n < 0) return; //bc
        if(n==0) dp[0]++;
        rec2(n-1, dp);
        rec2(n-2, dp);
    }

    /**
     * TLE
     */
    public int climbStairsRecurseBacktracking2(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return climbStairsRecurseBacktracking2(n-1) + climbStairsRecurseBacktracking2(n-2);
    }
}
