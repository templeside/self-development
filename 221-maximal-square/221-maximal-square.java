class Solution {
    /*
    maximal square 찾는법:
    1. horizontal
    2. vertical
    3. diagonal
    이 셋중에서 min을 찾는 것이 max square을 찾는법.
    
    iteration 해 가면서 maximal sqaure을 찾으면 되겠다.
    for(int r=0; r<rMax; r++){
        for(int c=0; c< cMax; c++){
            recursion(r,c, matrix, dp )
        }
    }
    */
    public int maximalSquare(char[][] matrix) {
        int rMax= matrix.length;
        int cMax = matrix[0].length;
        int[][] dp = new int[rMax+1][cMax+1];
        int max = 0;
        
        for(int r=1; r<=rMax; r++){
            for(int c=1; c<=cMax; c++){
                if(matrix[r-1][c-1] == '1'){
                    dp[r][c] = Math.min(Math.min(dp[r][c-1], dp[r-1][c]), dp[r-1][c-1])+1;
                    max = Math.max(dp[r][c], max);
                }
            }
        }
        return max*max;
    }
    
}