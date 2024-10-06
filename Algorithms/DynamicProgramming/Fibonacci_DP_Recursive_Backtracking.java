package Algorithms.DynamicProgramming;

/**
 * <pre>
 * Bigger number to smaller number 
 * @TimeComplexity: O(2^n) due to repitative calls
 * 
 * i.e similar to Top Down Memoization but without using extra space fo an array for memoization
 * 
 * 
 * fib(5) = 5+4 = 9, fib(4) = 4+3 = 7, fib(3) = 3+2 = 5, fib(2) = 2+1 = 3, fib(1) = 1+0 = 1
 * 
 * BINARY TREE REPRESENTATION OF RECURCIVE CALLS AS BELOW:
 *                      
 *                          5
 *                       ___|___
 *                      /       \
 *                     4         3
 *                    / \       / \
 *                   3   2     2   1
 *                  / \  /    / 
 *                 2   1 1   1
 *                /
 *               1 
 * 
 * <code>"
 * in simple terms, first all the left values are calculated => i.e 
 * Once the last left node value (eg: 2) is obtained from method base case or previous call
 * calculate right sibling node vlaue (eg: 1) if we have one, and then add both these siblings in nearest parent node (eg: 3)
 * Here, this nearest parent node is nothing but a left node sibling of another right node, 
 * then calculate it's right sibling node and then sum up them in it's nearest parent node and so on ...
 * "</code>
 * </pre>
 * 
 * That's we use recursive approach in graphs and trees
 * 
 * 
 * @author Srinivas Vadige
 * @since 06 Oct 2024
 */
public class Fibonacci_DP_Recursive_Backtracking {
    public static void main(String[] args) {
        System.out.println(fib(5));
    }

    public static int fib(int n) {
        if (n <= 1) { // base case
            return n;
        }
        int temp = fib(n - 1) + fib(n - 2);
        System.out.print(temp + " "); // prints repeatative calls as well
        return temp;
    }
}
