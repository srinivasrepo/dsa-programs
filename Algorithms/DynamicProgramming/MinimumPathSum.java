package Algorithms.DynamicProgramming;

/**
<pre>
 0 & +ve nums

 top left to bottom right

    |°            |
    |    ↓        |
    |      -→     |
    |            °|

 dpad => down or right

                    ----- int[][] grid -----

                            [0][0]
                    [1][0]           [0][1]
                [2][0] [1][1]    [1][1]   [0][2]


 Patterns:
 1. weighted binary graph --> memo or rb ???
 2. [1][1] -- repeated ele => memo will work even weights / distance => because we want min. So, memo min distance
 3. top-down memo dp -> yes keep the small and break the rec of big -- or bottom-up tabulation

[1,3,1]
[1,5,1]
[4,2,1]

</pre>




@author Srinvas Vadige, srinivas.vadige@gmail.com
@since 14 Oct 2024
@see /Algorithms/DynamicProgramming/UniquePathSum.java

*/
public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println("minPathSumBottomUpTabulation: " + minPathSumBottomUpTabulation(grid));
        System.out.println("minPathSumBottomUpTabulationMyApproach: " + minPathSumBottomUpTabulationMyApproach(grid));
        System.out.println("minPathSumTopDownMemoMyApproach: " + minPathSumTopDownMemoMyApproach(grid));
        System.out.println("minPathSumTopDownMemo: " + minPathSumTopDownMemo(grid));
    }

    /**
     * Time Complexity: O(m) + O(n) + O(mn) = O(mn)
     * Space Complexity: O(mn)
     */
    public static int minPathSumBottomUpTabulation(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n]; // or we can just modify the existing grid
        dp[0][0] = grid[0][0]; // don't use clone() as we are adding lefts and tops below
        for(int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * Time Complexity: O(mn)
     * Space Complexity: O(mn)
     */
    public static int minPathSumBottomUpTabulationMyApproach(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){

         int left = j>0? ( dp[i][j-1] ): 0;
         int top = i>0? ( dp[i-1][j] ) : 0;

         if(j==0)
            dp[i][j] += ( top + grid[i][j]  );
         else if(i==0)
            dp[i][j] += (  left + grid[i][j]  );
         else
            dp[i][j] += (  Math.min(top, left) + grid[i][j]  );
            }
        }

        return dp[grid.length-1][grid[0].length-1];
    }

    public static int minPathSumBottomUpTabulationSimilar(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j] = Integer.MAX_VALUE;
                if(i+j == 0){
                    dp[i][j] = grid[i][j];
                }
                if(i>0){
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }
                if(j>0){
                    dp[i][j] = Math.min(dp[i][j],dp[i][j-1] + grid[i][j]);
                }
            }
        }
        return dp[n-1][m-1];
    }


    /**
     * [1,3,1]         [1,4,5]  - - -
     * [1,5,1]         [2,7,6]      |     => is the min path
     * [4,2,1]         [6,8,7]      |
     *
     *                                                         rec(3,3)
     *                                             ________________|________________________________________
     *                                            /                                                         \
     *                                         rec(2,3)                                                  rec(3,2)
     *                                ____________|___________________________                                ____________|______________
     *                               /                                        \                              /                           \
     *                            rec(1,3)                                rec(2,2)                         rec(2,2)                   rec(3,1)
     *                  ____________|_____________                        _____|_____
     *                 /                          \                    (1,2)       (2,1)
     *               rec(0,3)                   rec(1,2)            (0,2)  (1,1)      |
     *       _________|_________             ______|_______        (0,1)  (0,1)(1,0)
     *      /                   \           /              \
     *     --                 rec(0,2)    rec(0,2)        rec(1,1)
     *                           \                       ___|___
     *                        rec(0,1)                  /       \
     *                           \                  rec(0,1)    rec(1,0)
     *                        rec(0,0)                 \         /
     *                                             rec(0,0)    rec(0,0)
     *
     */
    public static int minPathSumTopDownMemoMyApproach(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        recMyApproach(grid, dp, grid.length-1, grid[0].length-1);
        return dp[grid.length-1][grid[0].length-1];
    }
    // without sending m,n to child node/recursion we can't do grid[m-1][n] top, grid[m][n-1] left
    public static int recMyApproach(int[][] grid, int[][] dp, int m, int n) {
        if(m == 0 && n == 0) return dp[m][n] = grid[m][n];

        if(dp[m][n] != 0)
            return dp[m][n];

        // row=0 means left
        if(m == 0) return dp[m][n] = grid[m][n] + recMyApproach(grid, dp, m, n-1);
        // col=0 means top
        if(n == 0) return dp[m][n] = grid[m][n] + recMyApproach(grid, dp, m-1, n);

        int left = recMyApproach(grid, dp, m, n-1);
        int top = recMyApproach(grid, dp, m-1, n);
        return dp[m][n] = grid[m][n] + Math.min(left, top);
    }

    public static int minPathSumTopDownMemo(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int dp[][] = new int[m][n];
        return find(grid, m - 1, n - 1, dp);
    }
    public static int find(int[][] grid, int m, int n, int dp[][]) {
        if (m == 0 && n == 0)    return grid[m][n];
        else if (m < 0 || n < 0)    return Integer.MAX_VALUE;
        else if (dp[m][n] != 0)    return dp[m][n];
        return dp[m][n] = grid[m][n] + Math.min(find(grid, m - 1, n, dp), find(grid, m, n - 1, dp));
    }



    public static int minPathSumTopDownMemo2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){  // not required
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        return rec2(grid,dp,0,0);
    }

    private static int rec2(int[][] grid, int[][] dp, int i, int j) { // or pass m, n as params
        int m = grid.length;
        int n = grid[0].length;

        if (i == m-1 && j == n-1) return grid[i][j];
        if (dp[i][j] != -1) return dp[i][j]; // compare == 0
        int min = Integer.MAX_VALUE;
        if (i+1 < m) min = Math.min(min, rec2(grid, dp, i+1, j));
        if (j+1 < n) min = Math.min(min, rec2(grid, dp, i, j+1));
        dp[i][j] = min + grid[i][j];
        return dp[i][j];
    }





    /**
     *
     * It's not working --------
     *
     * @TimeComplexity: O(mn)
     * @SpaceComplexity: O(mn)
     */
    public static int minPathSumTopDownMemo3(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        rec3(grid, dp, 0);
        return dp[m-1][n-1];
    }

    private static void rec3(int[][] grid, int[][] dp, int i) { // or pass m, n as params
        int m = grid.length;
        int n = grid[0].length;
        if (i == m-1) {
            dp[i%2][n-1] = grid[i][n-1];
            for (int j = n-2; j >= 0 ; j--) dp[i%2][j] = dp[i%2][j+1]+grid[i][j];
            return;
        }
        rec3(grid,dp,(i+1));
        dp[i%2][n-1] = dp[(i+1)%2][n-1] + grid[i][n-1];
        for (int j = n-2; j >= 0; j--)
        dp[i%2][j] = Math.min(dp[(i+1)%2][j],dp[i%2][j+1]) + grid[i][j];
    }

}
