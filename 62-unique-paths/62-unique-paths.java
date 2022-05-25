class Solution {
    /**
    [0,1]
    [1,2]
    [1,3]
    **/    
    public int uniquePaths(int m, int n) {
        int[][] arr= new int[m][n];
        
        for(int[] dd: arr){
            Arrays.fill(dd,1);
        }
        
        for(int r=1; r<m;r++){
            for(int c = 1; c<n;c++){
                arr[r][c] = arr[r-1][c] + arr[r][c-1];
            }
        }
        
        return arr[m-1][n-1];
    }
}