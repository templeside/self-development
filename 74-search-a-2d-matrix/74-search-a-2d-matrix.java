class Solution {
/**
1. first find the row by the last value
2. find the target by the range.

**/
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length, n = matrix[0].length;
        int r = 0;
        while( r< m && target> matrix[r][n-1])
            r++;
        
        int left=0, right=n-1;
        while(left<= right && r<m){
            int mid = left+(right-left)/2;
            if(matrix[r][mid] == target)return true;
            else if(matrix[r][mid]>target)
                right = mid-1;
            else
                left = mid+1;
        }
        return false;
    }
}