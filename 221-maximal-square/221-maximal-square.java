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
        int[][] dp = new int[rMax][cMax];
        int max = 0;
        
        for(int r=0; r<rMax; r++){
            dp[r][0] = (int)(matrix[r][0]-'0');
            max = Math.max(dp[r][0], max);
        }
            
        for(int c=0; c<cMax; c++){
            dp[0][c] = (int)(matrix[0][c]-'0');
            max = Math.max(dp[0][c], max);
        }
            
        
        for(int r=1; r<rMax; r++){
            for(int c=1; c<cMax; c++){
                if(matrix[r][c] == '1'){
                    dp[r][c] = Math.min(Math.min(dp[r][c-1], dp[r-1][c]), dp[r-1][c-1])+1;
                    max = Math.max(dp[r][c], max);
                }
            }
        }
        return max*max;
    }
    
}

//     private static int maximumSizeSquareSubmatrixWithAllOnes(int[][] matrix) {
// 4	        int maxSize = 0;
// 5	        int r = matrix.length;
// 6	        int c = matrix[0].length;
// 7	         
// 8	        int[][] table = new int[r][c];
// 9	
// 10	        for (int i = 0; i < r; i++) {
// 11	            for (int j = 0; j < c; j++) {
// 12	                 
// 13	                if (i == 0 || j == 0) {
// 14	                    table[i][j] = matrix[i][j];
// 15	                    maxSize = table[i][j] > maxSize ? table[i][j] : maxSize;
// 16	                }
// 17	                 
// 18	                else if (matrix[i][j] == 0) {
// 19	                    table[i][j] = 0;
// 20	                }
// 21	                 
// 22	                else {
// 23	                    table[i][j] = min(table[i - 1][j - 1], table[i - 1][j], table[i][j - 1]) + 1;
// 24	                    maxSize = table[i][j] > maxSize ? table[i][j] : maxSize;
// 25	                }
// 26	            }
// 27	        }
// 28	
// 29	        return maxSize;
// 30	    }
