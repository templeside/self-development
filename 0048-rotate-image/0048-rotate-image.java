class Solution {
    /*
    transpose
    flip
    
    */
    public void rotate(int[][] matrix) {
        transpose(matrix);
        flip(matrix);
    }
    public void transpose(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i=0; i<m; i++){
            for(int j= i+1; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    public void flip(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        for(int r=0; r<m; r++){
            for(int c=0; c< n/2; c++){
                int temp = matrix[r][c];
                matrix[r][c] = matrix[r][n-1-c];
                matrix[r][n-1-c] = temp;
            }
        }
    }
}