class Solution {
    /*
    do the bfs to reach to the next move
    if found the closest food, then return the length.

    if not found but visited all the availalbe  paths, return -1

    do iteration for finding current location


    bfs:
        data structure - queue, dirs
        while(queue is not empty)
            increment the length
            iterate currLevel:
                check isFood(#)
                    if food, return length
                if not food('0')
                    look for adjcencies:
                        check is the adj valid:
                            0<= newR< m
                            0<= newC< n
                            if it is not obstacle
                            add to queue.
    */
    public int getFood(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int r=0; r< m;r++){
            for(int c=0; c<n; c++){
                if(grid[r][c] == '*'){
                    return bfs(r,c, grid);
                }
            }
        }
        return -1;
    }
    public int bfs(int r, int c, char[][]grid){
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue =new ArrayDeque<>();
        visited[r][c] = true;
        queue.add(new int[]{r,c});
        int length = 0;
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        // do the bfs to reach to the next move
        while(!queue.isEmpty()){
            int qSize= queue.size();
            for(int i=0; i< qSize; i++){
                int[] currCoordinate = queue.poll();
                int currR = currCoordinate[0];
                int currC = currCoordinate[1];

                // if found the closest food, then return the length.
                if(grid[currR][currC] == '#'){
                    return length;
                }
                // if not found but visited all the availalbe  paths, return -1
                for(int[] dir: dirs){
                    int newR = currR+ dir[0];
                    int newC = currC+ dir[1];
                    if(newR>=0 && newR<m && newC>=0 && newC<n && !visited[newR][newC] && grid[newR][newC] != 'X'){
                        visited[newR][newC] = true;
                        queue.add(new int[]{newR, newC});
                    }
                }

                // do iteration for finding current location
            }
            length ++;
        }
        return -1;
    }
}