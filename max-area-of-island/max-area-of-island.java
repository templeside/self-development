

class Solution {
    int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    
    
    public int maxAreaOfIsland(int[][] grid) {
        int maxCount=0;
        
        for(int r=0; r<grid.length;r++){
            for(int c =0; c<grid[0].length;c++){
                if(grid[r][c] ==1){
                    int count = dfs(r,c,grid);
                    maxCount = Math.max(maxCount, count);
                }
            }
        }
        return maxCount;
    }
    
    private int dfs(int r, int c, int[][] grid){
        int rSize = grid.length;
        int cSize = grid[0].length;
        int count=0;
        
        if(r<0 || r>=rSize || c<0 || c>= cSize || grid[r][c] !=1)
            return 0;
        
        grid[r][c] = 0;
        for(int i=0; i<dir.length; i++){
            int x = r+dir[i][0];
            int y = c + dir[i][1];
            count += dfs(x,y,grid);
        }
        return count+1;
    }
}