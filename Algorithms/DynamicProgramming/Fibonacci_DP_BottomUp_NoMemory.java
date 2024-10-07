package Algorithms.DynamicProgramming;

/**
 * @Approach: Bottom Up - No Memory i.e just normal for loop
 * @TimeComplexity: O(n)
 * 
 * 
* @author Srinvas Vadige 
* @since 06 Oct 2024
*/
public class Fibonacci_DP_BottomUp_NoMemory {
    public static void main(String[] args) {
        int n = 5;
        fibonacci(n);
    }
    
    
    // Normal for loop and note that we cannot do top to bottom in this approach
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        
        int prev = 0;
        int curr = 1;
        System.out.print("0 1 ");
        
        for (int i = 2; i <= n; i++) { // move prev & curr values to next
            int temp = prev + curr;
            prev = curr;
            curr = temp;

            System.out.print(temp + " ");
        }

        return curr;
    }


}
