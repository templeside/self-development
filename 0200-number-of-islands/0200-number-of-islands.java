class Solution {
    /*
    by iterating all grids, find the land
    
    if found land,
        count island
        do dfs to check all the connected land 
        
    */
    public int numIslands(char[][] grid) {
        int count =0;
        int m =grid.length;
        int n= grid[0].length;
        for(int r=0; r< m; r++){
            for(int c= 0; c< n; c++){
                if(grid[r][c] == '1'){
                    count++;
                    dfs(r,c,grid);
                }
            }
        }
        return count;
    }
    
    /*
    change coordinate element to -1
    look for adjacencies = {{0,1},{0,-1},{1,0},{-1,0}}
    */
    public void dfs(int r, int c, char[][] grid){
        int[][] dirs =new  int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int m =grid.length;
        int n= grid[0].length;

        grid[r][c] = '0';
        for(int[] adj: dirs){
            int newR = r+ adj[0];
            int newC= c+ adj[1];
            if(newR>=0 && newR<m && newC>=0 && newC<n && grid[newR][newC] == '1')
                dfs(newR,newC, grid);
        }
    }
}