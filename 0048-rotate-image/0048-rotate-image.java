class Solution {
    /*
    i could rotate image by using technique
    
    transpose the items
    then flip matrix.
    
    transpose - matrix
    left          right
top 0,0     0,1     0,2
    1,0     1,1     1,2
bot 2,0     2,1     2,2

from start to n/2, 
iterating (i=0; i< n; i++)
    for(j= i+1; j<n; j++)
        swap matrix[i][j] = matrix[j][i]
    we'll get the transpose
    
 [[1,2,3],
  [4,5,6],
  [7,8,9]]
  

    */
    public void rotate(int[][] matrix) {
        transpose(matrix);
        flip(matrix);
    }
    /*
 [[1,4,7],
  [2,5,8],
  [3,6,9]]
    */
    public void transpose(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i=0; i< m; i++){
            for(int j=i+1; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
/*
 [[7,4,1],
  [8,5,2],
  [9,6,3]]
  col is changing
  matrix[r][i] = matrix[r][j]
*/
    public void flip(int[][] matrix){

        for(int r=0; r< matrix.length; r++){
            int left =0;
            int right = matrix[0].length-1;
            while(left< right){
                int temp = matrix[r][left];
                matrix[r][left] = matrix[r][right];
                matrix[r][right] = temp;
                left++;
                right--;
            }
        }
    }
}