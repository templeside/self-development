class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        ArrayDeque<int[]> bfsIterator = new ArrayDeque<>();
        
        for(int r=0; r< m; r++){
            for(int c=0; c< n; c++){
                if(mat[r][c] ==0){
                    bfsIterator.add(new int[]{r,c});
                }
                else{
                    mat[r][c] = Integer.MAX_VALUE;
                }
            }
        }
        int[] rDir = new int[]{0,0,1,-1};
        int[] cDir = new int[]{1,-1,0,0};
        
        while(bfsIterator.size()>0){
            int[] coordinate = bfsIterator.poll();
            for(int i=0; i< 4; i++){
                int newR = coordinate[0] +rDir[i];
                int newC = coordinate[1] +cDir[i];
                
                if(newR>=0 && newR< m && newC>= 0 && newC<n && mat[coordinate[0]][coordinate[1]]+1< mat[newR][newC]){
                    bfsIterator.add(new int[]{newR,newC});
                    mat[newR][newC] = mat[coordinate[0]][coordinate[1]]+1;
                }
            }
        }
        return mat;
    }
}