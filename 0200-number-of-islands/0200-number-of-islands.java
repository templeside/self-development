class Solution {
    /*
    look for grid
    
    if found land, 
        cross out the adj land. adj lands are:
            {0,1},{0,-1},{1,0},{-1,0}
            if valid - in range, it is land
                subrecursion
    
    */
    public int[][] dirs= new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        int count=0;
        for(int r=0; r< grid.length; r++){
            for(int c=0; c< grid[0].length; c++){
                if(grid[r][c] == '1'){
                    dfs(r,c,grid);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int r, int c, char[][] grid){
        grid[r][c] = '0';
        
        for(int[] dir: dirs){
            int newR = r+ dir[0];
            int newC = c+ dir[1];
            
            //if valid, recursion
            if(newR>=0 && newR< grid.length && newC>=0 && newC< grid[0].length && grid[newR][newC] == '1'){
                dfs(newR, newC, grid);
            }
        }
    }
}