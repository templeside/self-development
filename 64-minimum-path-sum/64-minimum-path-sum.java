class Solution {
    /**
    having the dynamic programming to represent the minimum path sum from the top left.
    dp[row][col] = minPath sum.
    
    there are two options:
    1. from left
    2. from up.
    
    to represent in pseudo code,
    dp[r][c] = Math.min(dp[r-1][c], dp[r][c-1]).
    
    because most left row and most top cols are fixed,
    so initialize first.
    
    because I don't want to use extra memory, I would iterate in `grid`
    **/
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        for(int r=1; r<m; r++)
            grid[r][0] = grid[r-1][0] + grid[r][0];
        for(int c=1; c<n; c++)
            grid[0][c] = grid[0][c-1]+ grid[0][c];
        
        for(int r=1; r< m; r++){
            for(int c=1; c<n; c++){
                grid[r][c] = Math.min(grid[r-1][c], grid[r][c-1]) + grid[r][c];
            }
        }
        return grid[m-1][n-1];
    }
}