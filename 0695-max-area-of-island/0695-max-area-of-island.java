class Solution {
    /*
    1. iterate all matrix for looking island.
    2. if found 1, look for the area
        while iterating:
            check 4 dirs
            return area
            update maxArea
            
    
    dfs(x,y grid, visited):
        if(out of bound, grid[][] == 0)
        
        
        for(int[] adjacent: dirs){
            if(grid[newx][newy] ==1){
                dfs();
            }
        }
        
        return area
        
    int[][] visited= new int[][]
    Integer maxArea = 0;
    */
    public boolean[][] visited;
    public int[] rDir = new int[]{1,-1,0,0};
    public int[] cDir = new int[]{0,0,1,-1};
    
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        visited = new boolean[grid.length][grid[0].length];
        
        for(int r=0; r< grid.length; r++){
            for(int c=0; c< grid[0].length; c++){
                if(grid[r][c] == 1)
                    maxArea = Math.max(maxArea, dfs(r, c, grid, visited));
            }
        }
        
        return maxArea;
    }
    
    public int dfs(int r, int c, int[][] grid, boolean[][] visited){
        if(r <0 || r>= grid.length || c<0 || c>= grid[0].length || grid[r][c] ==0 || visited[r][c])
            return 0;
        
        int currArea = 1;
        visited[r][c] = true;
        
        for(int i=0; i< rDir.length; i++){
            int newR = r + rDir[i];
            int newC = c + cDir[i];
            
            currArea += dfs(newR, newC, grid, visited);
        }
        return currArea;
    }
}