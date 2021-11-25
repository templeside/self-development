class Solution {
    public int minPathSum(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;
        
        for(int r=0; r<m; r++){
            for(int c = 0; c<n; c++){
                if(r == 0 && c==0)
                    grid[r][c] = grid[r][c];
                else if(r==0 && c !=0)
                    grid[r][c] = grid[r][c] + grid[r][c-1];
                else if(r!=0 && c ==0)
                    grid[r][c] = grid[r][c] +grid[r-1][c];
                else
                    grid[r][c] = grid[r][c] + Math.min(grid[r-1][c] , grid[r][c-1]);
            }
        }
        return grid[m-1][n-1];
    }
}