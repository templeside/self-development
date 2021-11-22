class Solution {
    int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        int count=0;
        
        for(int r=0; r<grid.length;r++){
            for(int c =0; c<grid[0].length;c++){
                if(grid[r][c] =='1'){
                    dfs(r,c,grid);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void dfs(int r, int c, char[][] grid){
        int rSize = grid.length;
        int cSize = grid[0].length;
        if(r<0 || r>=rSize || c<0 || c>= cSize || grid[r][c] !='1')
            return;
        grid[r][c] = '0';
        for(int i=0; i<dir.length; i++){
            int x = r+dir[i][0];
            int y = c + dir[i][1];
            dfs(x,y,grid);
        }
        return;
    }
}