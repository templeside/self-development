class Solution {
    /*
    staritng from the coordinate [sr, sc], look for the adjacent coordinates are they connected.

    if the value is same, 
        add on tothe next queue.

    [[1,1,1],
     [1,1,0],
     [1,0,1]]
    
    */
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited =new boolean[image.length][image[0].length];

        queue.add(new int[]{sr,sc});
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int[] currCoordinate = queue.poll();
                int currR = currCoordinate[0];
                int currC = currCoordinate[1];

                image[currR][currC] = color;
                visited[currR][currC] = true;

                for(int[] dir: dirs){
                    int newR = currR + dir[0];
                    int newC = currC + dir[1];

                    //check valid coordinate
                    if(newR>=0 && newR< image.length && newC>=0 && newC< image[0].length && image[newR][newC] == originalColor && !visited[newR][newC]){
                        queue.add(new int[]{newR, newC});
                    }
                }
            }
        }
        return image;
    }
}