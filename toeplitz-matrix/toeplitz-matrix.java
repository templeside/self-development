class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
//         for loops
//             1. left rows
//             2. top cols
//             if diagonal is not same as the first value, 
//                 return false;
            
//             return true;
        for(int r=0; r<matrix.length; r++){
            if(!isDiagonal(r,0,matrix,matrix[r][0]))
                return false;
        }
        
        for(int c=0; c<matrix[0].length; c++){
            if(!isDiagonal(0,c,matrix,matrix[0][c]))
                return false;
        }
        return true;
        
    }
//     (r,c, val matrix) recursion
    private boolean isDiagonal(int r, int c, int[][]matrix, int val ){
        int row = matrix.length;
        int col = matrix[0].length;
        
        if(r>=row || c >=col)     //base case to reach to the end
            return true;
        
        return matrix[r][c] == val && isDiagonal(r+1, c+1, matrix, val);
    }
}