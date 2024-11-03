class Solution {
    /*
    look for the island

        if found, 
            count++
            do the dfs to cancel out the adjacencies to 0 - becausee this is one island.
    */
    public int numIslands(char[][] grid) {
        int count =0;
        int m= grid.length;
        int n =grid[0].length;
        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
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

        int[][] dirs= new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        //adjacencies
        for(int[] dir: dirs){
            int newR = r+ dir[0];
            int newC = c+ dir[1];

            //if valid. in range, grid[newR][newC] ==1
            
            if(newR >= 0 && newR< grid.length && newC>=0 && newC < grid[0].length && grid[newR][newC] == '1'){
                dfs(newR,newC, grid);
            }
        }
        return;
    }
}