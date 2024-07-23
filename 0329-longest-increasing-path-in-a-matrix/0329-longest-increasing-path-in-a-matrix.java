class Solution {
    /*
    m - max row
    n - max col
    */
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int longest = 0;
        int[][] memo = new int[m][n];
        
        for(int r=0; r< m; r++){
            for(int c=0; c< n; c++){
                longest = Math.max(longest, dfs(r,c, matrix, memo));
            }
        }
        return longest;
    }
    
    public int[] rDir = new int[]{0,0,1,-1};
    public int[] cDir = new int[]{1,-1,0,0};
        
    public int dfs(int r, int c, int[][] matrix, int[][]memo){
        if(memo[r][c] !=0)
            return memo[r][c];
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int longestPath = 1;
        
        for(int i=0; i<4; i++){
            int newR = r+rDir[i];
            int newC = c+cDir[i];
            
            if(newR>=0 && newR< m && newC>=0 && newC< n && matrix[r][c] < matrix[newR][newC])
                longestPath = Math.max(longestPath, (dfs(newR, newC, matrix, memo)+1));
            
            memo[r][c] = longestPath;
        }
        return memo[r][c];
    }
}