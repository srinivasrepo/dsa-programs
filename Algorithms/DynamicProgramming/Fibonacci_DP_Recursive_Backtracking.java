package Algorithms.DynamicProgramming;

/**
 * <pre>
 * Bigger number to smaller number 
 * @TimeComplexity: O(2^n) due to repitative calls
 * 
 * i.e similar to Top Down Memoization but without using extra space fo an array for memoization
 * 
 * 
 * BINARY TREE REPRESENTATION OF RECURCIVE CALLS AS BELOW:
 * 
 *                                   -------------- for fib(8) ---------------
 *                     
*                                                       8
*                                                 ______|_______                         
*                                                /              \
*                                               7                6_________________
*                                   ____________|______                      ______|______ 
*                                  /                   \                   /              \         
*                                 6                     5                  5                4                                                                                                                                                                          
*                           ______|_____             ___|___            ___|___            / \
*                          /            \           /       \          /       \          3   2
*                         5              4         4         3        4         3        /\  /\
*                      ___|___          / \       / \       / \      / \       /\       2  1 1 0  
*                     /       \        3   2     3   2     2   1    3   2     2  1     /\
*                    4         3      /\  /\    /\   /\   /\       /\  /\    /\       1  0
*                   / \       /\     2  1 1 0  2  1  1 0  1 0     2 1 1 0   1  0
*                  3   2     2  1   /\         /\                /\
*                 /\  /\    /\    1  0        1  0              1  0                                                                                                                                                
*                2  1 1 0  1  0                                
*               /\
*              1  0
*
*
*                
 * NOTE:
 * -> fib(2) is the minimum recursion call cause we return n when n = 0 or n = 1 in base case
 * -> Node is differenent and sum is different
 * -> for leaf node, sum is the same as node value
*                                               
*                     --------- for fib(6) with sum -----------       
*                                                        
*                                       6 (sum = 8)
*                              _________|________
*                             /                  \                     
*                            5 (sum = 5)          4 (sum = 3)  
*                    ________|____________ 
*                   /                     \   
*                  4(s=3)                  3(s=2) 
*                 / \                     /\ 
*           (s=2)3   2(s=1)         (s=1)2  1 --> leaf
*               /\   /\                 /\   
*         (s=1)2  1  1 0--> leaves     1  0 -----> leaves
*             /\  |-------> leaf  
*            1  0 --------> leaves                
*                                                                                                                                   
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
        int n = 6;
        fib(n);
        // for n=6 then every recursive node sum and leaves will be printed as =>
        // 1 0 1 1 2 1 0 1 3 1 0 1 1 2 5 1 0 1 1 2 1 0 1 3 8 
        // --> where (1 0 1 1 2 1 0 1 3) 1 0 1 1 2 5 are left sub-tree of parent node i.e 6. and (1 0 1 1 2 1 0 1 3) upto n=4 node

        // and for n=8 then every recursive sum (only temp not leaves) will be printed as =>
        // 1 2 1 3 1 2 5 1 2 1 3 8 1 2 1 3 1 2 5 13 1 2 1 3 1 2 5 1 2 1 3 8 21
    }

    public static int fib(int n) {
        if (n == 0 || n == 1) { // base case for leaf nodes
            System.out.println( "leaf node: " + n + " ");
            return n;
        }
        int temp = fib(n - 1) + fib(n - 2); // or int temp = fib(n - 2) + fib(n - 1); 
        System.out.println( "node: " + n + ", " + "sum of " + (n-1) + " and " + (n-2) + " nodes: " + temp); // prints repeatative calls as well
        return temp;
    }
}
