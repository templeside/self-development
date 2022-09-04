class Solution {
    /**
    that means we know the number of paths are coming from left and north side.
    which means I can divide this problem into subproblem, using dynamic programming.
    
    dp[row][col] = num paths I can get from the origin.
    subproblems would have two options to get the path:
    1. from left
    2. from right
    in tablized position, it can be defined as,
    dp[r][c] = dp[r][c-1] + dp[r-1][c];
    
    initialize Input: m = 5, n = 3
    because most left rows and most north cols are having only one way, we should initialize
    dp[i][0] = 1
    dp[0][i] = 1.
    
    r/c 0 1 2 3 4
    0   1 1 1 1 1
    1   1 
    2   1 
    
    then the curr Algorithm dp[r][c] = dp[r][c-1] + dp[r-1][c] is beginning.
    r/c 0 1 2 3 4
    0   1 1 1 1 1
    1   1 2 3 4 5
    2   1 3 6 10 15
    
    Output: 15
    **/
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int r=0; r<m; r++)
            dp[r][0] = 1;
        for(int c=0; c<n; c++)
            dp[0][c] = 1;
        
        for(int r=1; r<m; r++){
            for(int c=1; c<n; c++){
                dp[r][c] = dp[r][c-1] + dp[r-1][c];
            }
        }
        return dp[m-1][n-1];
    }
}
