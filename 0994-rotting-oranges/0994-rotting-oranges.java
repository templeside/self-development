class Solution {
    /*
        
[[2,1,1],
 [1,1,0],
 [0,1,1]]
 
 0 empty
 1 fresh
 2 rotten
 
 
    */
    public int orangesRotting(int[][] grid) {
        Queue<int[]> iterator = new ArrayDeque<>();
        int m = grid.length;
        int n= grid[0].length;
        int numWholeOrange = 0;

        //find all rotten tiems
        for(int r=0; r< m; r++){
            for(int c=0; c< n; c++){
                //add to queue
                if(grid[r][c] == 2){
                    iterator.add(new int[]{r,c});
                }
                if(grid[r][c] ==1)
                    numWholeOrange++;
            }
        }
        
        if(numWholeOrange == 0)
            return 0;

        int count =-1;
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        //while bfs:
        while(!iterator.isEmpty()){
            count++;
            int iteratorSize = iterator.size();
            
            // having for loop level by level
            for(; iteratorSize>0; iteratorSize--){
                // update grid
                int[] curr = iterator.poll();
                int currR = curr[0];
                int currC = curr[1];
                
                
                for(int[] adj: dirs){
                    
                    int newR = currR+adj[0];
                    int newC = currC+adj[1];
                    //if found adj grid[newR][newC] == 1
                    
                    if(newR>=0 && newR< m && newC>=0 && newC< n && grid[newR][newC] == 1){
                        numWholeOrange--;
                        iterator.add(new int[]{newR, newC});
                        grid[newR][newC] = 2;

                        
                    }
                }
            }
        }
    
        return numWholeOrange == 0? count: -1;
    }
}