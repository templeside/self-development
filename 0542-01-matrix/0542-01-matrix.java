class Solution {
    /*
    first find out all the coordinates where mat[r][c] == 0
    having the visited matrix, keep track of the visited matrix or not.

    by looking for next coordinate, increment the distance by 1

    algorithm:
        find all coordinate where mat[r][c] == 0 and add to queue
        
        while iteration:
            look for adjacencies is it visited:
                set value mat[adjR][adjC] = mat[r][c]+1
                add the new adj to queue to look for adjacencies

    data structure visited
    */
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue =new ArrayDeque<>();
        
        for(int r=0; r< m; r++){
            for(int c=0; c< n; c++){
                if(mat[r][c] == 0){
                    queue.add(new int[]{r,c});
                    visited[r][c] = true;
                }
            }
        }

        int[][] dirs=  new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        /*
        mat
        [[0,0,0],
         [0,1,0],
         [1,1,1]]

        visited
        [[t,t,t],
         [t,1,t],
         [1,1,1]]
        */
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0; i< size; i++){
                int[] currCoordinate = queue.poll();
                int currR = currCoordinate[0];
                int currC = currCoordinate[1];

                for(int[] dir: dirs){
                    int newR = currR+ dir[0];
                    int newC = currC+ dir[1];

                    //check valid - in matrix, not visited
                    if(newR>=0 && newR< m&& newC>=0 && newC< n && !visited[newR][newC]){
                        queue.add(new int[]{newR, newC});
                        visited[newR][newC] = true;
                        mat[newR][newC] = mat[currR][currC]+1;
                    }
                }
            }
        }
        return mat;
    }
}