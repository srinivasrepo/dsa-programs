package Algorithms.DynamicProgramming;

import java.util.Arrays;

/**
 * 
 * smaller number to bigger number
 * 
 * @Approach: Bottom Up Tabulation - add series in array using for loop 
 * @TimeComplexity: O(n)
 * 
 * 
* @author Srinvas Vadige 
* @since 21 Sept 2024
*/
public class Fibonacci_DP_BottomUp_Tabulation {

    public static void main(String[] args) {
        int n = 5;        
        fib(n);
        fib2(n);
    }

    // loop from 2 but add 0,1 in series manually
    public static int fib(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // we already have the all previous 2 values in dp array we are just adding them
            if(i == n) System.out.println("Bottom Up DP, loop from 2: " + Arrays.toString(dp)); // jsut for printing
        }
        return dp[n]; // root node value
    }

    // loop from 0 and have 0, 1 base cases in the loop itslef add the remaining series in dp array
    public static int fib2(int n) {
        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++) {
            if (i <= 1) {  // 0,1 are base cases
                dp[i] = i; 
            } else {
                dp[i] = dp[i-1] + dp[i-2];
            }
            if(i == n) System.out.println("Bottom Up DP, loop from 0: " + Arrays.toString(dp)); // jsut for printing
        }
        return dp[n]; // root node value
    }
    
}
