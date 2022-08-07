class Solution {
    /**
    this one is for dynamic programming.
    starting from the highest, move down.
    highest -> lowest.
    having int[]{r,c,value}. 
    
    
    Input: matrix = 
    [[9,9,4]
    ,[6,6,8]
    ,[2,1,1]]
    starting from [0,0], do the dfs to get the increasing path.
    
    dfs(0,0, matrix, distanceMatrix) compare with 4 directions, not able to find the increasing values - distanceMatrix = 1
    dfs(0,1, matrix, distanceMatrix) compare with 4 directions, not able to find the increasing values - distanceMatrix = 1
    dfs(0,2,matrix, distanceMatrix) compare with 4 directions, able to find 9, and 8. find the bigger distance.
        dfs(1,2,matrix, distanceMatrix) compare with 4 directions, able to find 9, and 8. find the bigger distance.
    */
    public static int[] rDir = new int[]{0,0,1,-1};
    public static int[] cDir = new int[]{1,-1,0,0};
    public static int rMax;
    public static int cMax;
    public int longestIncreasingPath(int[][] matrix) {
        rMax = matrix.length;
        cMax = matrix[0].length;
        int[][] maxDistance = new int[rMax][cMax];
        
        int max=  0;
        for(int r=0; r< rMax; r++ ){
            for(int c =0; c< cMax; c++){
                max = Math.max(max, dfs(r,c, matrix, maxDistance));
            }
        }
        return max;
    }
    
    public int dfs(int r, int c, int[][] matrix, int[][] maxDistance){
        if(maxDistance[r][c] !=0)return maxDistance[r][c];
        int distanceMax = 1;
        for(int i=0; i< 4; i++){
            int newR = r+ rDir[i];
            int newC = c+ cDir[i];
            
            if(newR>=0 && newR< rMax && newC>=0 && newC< cMax && matrix[r][c]< matrix[newR][newC]){
                distanceMax = Math.max(distanceMax, dfs(newR, newC, matrix, maxDistance)+1);
            }
        }
        maxDistance[r][c] = distanceMax;
        return distanceMax;
    }
}