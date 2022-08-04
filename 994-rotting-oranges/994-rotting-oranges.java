class Solution {
    // first, find out all of the rotten oranges, count the whole oranges.
    // second, add all of the rotten oranges into queue. 
    // third, pull out the orange, increment rottenOrange number and looking for the adjacent oranges.
    //      if there is an orange, add to the queue.
    // return rottenOrange == number of whole oranges.
    public List<int[]> findAdjacents(int[] currCoordinate, int[][] grid){
        List<int[]> adjacents = new ArrayList<>();
        int[] rDir = new int[]{0,0,1,-1};
        int[] cDir = new int[]{1,-1,0,0};
        int rMax = grid.length;
        int cMax = grid[0].length;
        for(int i=0; i< 4; i++){
            int newR = currCoordinate[0]+ rDir[i];
            int newC = currCoordinate[1]+ cDir[i];
            if(newR>=0 && newR< rMax && newC>=0 && newC< cMax && grid[newR][newC] == 1)
                adjacents.add(new int[]{newR, newC});
        }
        return adjacents;
    }
    
    public int orangesRotting(int[][] grid) {        
        int numWholeOrange = 0;
        Queue<int[]> rottenQueue = new LinkedList<>();
        
        for(int r = 0; r< grid.length; r++){
            for(int c=0; c< grid[0].length; c++){
                if( grid[r][c] != 0)
                    numWholeOrange++;
                if(grid[r][c] == 2)
                    rottenQueue.add(new int[]{r,c});
            }
        }
        
        if(numWholeOrange==0)return 0;
        
        
        int spreadCount=-1;
        while(rottenQueue.size()>0){
            int n = rottenQueue.size();
            spreadCount++;
            for(int i=0; i< n; i++){
                numWholeOrange--;
                
                int[] currCoordinate = rottenQueue.poll();
                
                List<int[]> adjacencies = findAdjacents(currCoordinate, grid);
                for(int[] adjacent: adjacencies){
                    rottenQueue.add(adjacent);
                    grid[adjacent[0]][adjacent[1]] = 2;

                }
            }
        }
        
        return numWholeOrange==0? spreadCount : -1;
    }
}