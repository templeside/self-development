class Solution {
    /*
    add to queue.
    every level, it has its own rotting orange level.
    rotting only 4 directionally adjacent to a rotten orange level.

    count all the oranges
    first, find out all the rotten oranges and add to BFS queue
    
    then, do the bfs with this given value
    bfs:
        each level:
            minMinutes++
            each coordinate:
                change oragne status - grid[r][c] = 2
                look for adjacencies:
                    check is valid coordinate
                    if it is fresh
                        add to queue.

    check all the oranges are rotten 
    if(count !=0)
        return -1;
    
    return the minMinutes
    */
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int minMinutes = 0;
        int orangeCount =0;
        
        int m= grid.length;
        int n = grid[0].length;
        for(int r=0; r< m; r++){
            for(int c=0; c<n; c++){
                if(grid[r][c] == 1){
                    orangeCount++;
                }else if(grid[r][c] == 2){
                    orangeCount++;
                    queue.add(new int[]{r,c});
                    grid[r][c] = 2;
                }
            }
        }
        if(orangeCount ==0){
            return 0;
        }
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()){
            int qSize = queue.size();
            minMinutes++;
            for(int i=0; i< qSize; i++){
                int[] currCoordinate = queue.poll();
                int currR = currCoordinate[0];
                int currC = currCoordinate[1];

                orangeCount--;
                
                for(int[] dir: dirs){
                    int newR = currR+dir[0];
                    int newC = currC+dir[1];
                    if(newR>=0 && newR< m && newC>=0 && newC<n && grid[newR][newC] == 1){
                        grid[newR][newC] = 2;
                        queue.add(new int[]{newR, newC});
                    }
                }
            }
        }
        
        return orangeCount ==0? minMinutes-1: -1;
    }
}