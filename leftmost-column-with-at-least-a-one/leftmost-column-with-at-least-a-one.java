/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        // 1. starting from the right most column
        // 2. if( 1)
        //     add column
        // 3. if(0)
        //     add row
        int max_row = binaryMatrix.dimensions().get(0);
        int max_col = binaryMatrix.dimensions().get(1);
        
        int currRow = 0;
        int currCol = max_col-1;
        while(currRow<max_row && currCol >=0){
            if(binaryMatrix.get(currRow, currCol) ==1)
                currCol --;
            else if( binaryMatrix.get(currRow, currCol) ==0)
                currRow++;
        }
        return currCol+1 == max_col? -1: currCol+1;
    }
}