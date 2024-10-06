package Algorithms.DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Approach: Top Down DP with Memoization
 * @TimeComplexity: O(n)
 * @SpaceComplexity: O(n)
 * 
 * 
* @author Srinvas Vadige 
* @since 21 Sept 2024
*/
public class Fibonacci_DP_TopDown_Memoization {

    public static void main(String[] args) {
        int n = 5;

        // memoization with array
        int[] dp = new int[n+1];
        fib(n, dp);
        dp[1] = 1;
        System.out.println("Top Down DP with array: " + Arrays.toString(dp));
        
        // memoization with hashmap
        HashMap<Integer, Integer> dpMap = new HashMap<>();
        fib(n, dpMap);
        dpMap.put(0, 0);
        dpMap.put(1, 1);
        System.out.println("Top Down DP with hashmap: " + dpMap.values());
    }
        

    public static int fib(int n, int[] dp) {
        if(n == 0 || n == 1) return n; // base case
        if(dp[n] != 0) return dp[n];
        dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
        return dp[n];
    }

    public static int fib(int n, HashMap<Integer, Integer> dp) {
        if(n == 0 || n == 1) return n; // base case
        if(dp.containsKey(n)) return dp.get(n);
        int result = fib(n - 1, dp) + fib(n - 2, dp);
        dp.put(n, result);
        return result;
    }






    // Codeium AI coding assistant solutions
    public static int fib(int n, int a, int b) {
        if(n == 0 || n == 1) return n;
        int c = a + b;
        if(n == 2) return c;
        return fib(n - 1, b, c) + fib(n - 2, a, b);
    }

    public static int fib(int n, int a, int b, int[] dp) {
        if(n == 0 || n == 1) return n;
        if(dp[n] != 0) return dp[n];
        dp[n] = fib(n - 1, b, a + b, dp) + fib(n - 2, a, b, dp);
        return dp[n];
    }


    
}
