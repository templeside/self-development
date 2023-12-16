class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] diff = new int[m][n];
        
        //calculate the 1s and 0s
        int[] row0Counts = new int[m];
        int[] col0Counts = new int[n];
        
        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                if(grid[r][c] ==0){
                    row0Counts[r]++;
                    col0Counts[c]++;
                }
            }
        }
        
        for(int r=0; r<m; r++){
            for(int c= 0;c<n; c++){
                calculateDiff(r,c,grid, diff, row0Counts, col0Counts);
            }
        }
        return diff;
    }
    
    public void calculateDiff(int r, int c, int[][]grid, int[][] diff, int[] row0Counts, int[] col0Counts){
        int m = grid.length;
        int n = grid[0].length;
        
        int zerosRow = row0Counts[r];
        int zerosCol = col0Counts[c];
        int onesRow = m-zerosRow;
        int onesCol = n-zerosCol;
        diff[r][c] = onesRow+onesCol - zerosRow - zerosCol;
    }
}