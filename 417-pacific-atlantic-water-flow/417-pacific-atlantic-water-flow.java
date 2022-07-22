class Solution {
    /**
    starting from the ocean borderlines
    trying to spread out the grids that oceans can be visited.
    
    height[currIdx] <= height[childIdx]
    because we are going to do in reverse order.
    **/
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int maxR= heights.length;
        int maxC = heights[0].length;
        int [][] pacific = new int[maxR][maxC]; // 0 - not visited, 1 - canvisit, -1 - cannotvisit.
        int [][] atlantic = new int[maxR][maxC];
        List<List<Integer>> returnVal =new ArrayList<>();
        
        ArrayDeque<int[]> pacificQue = new ArrayDeque<>();
        ArrayDeque<int[]> atlanticQue = new ArrayDeque<>();
        
        for(int r=0; r<maxR;r++){
            pacific[r][0] = 1;
            atlantic[r][maxC-1] = 1;
            
            pacificQue.add(new int[]{r,0});
            atlanticQue.add(new int[]{r,maxC-1});
        }
        for(int c=0; c<maxC;c++){
            pacific[0][c] = 1;
            atlantic[maxR-1][c] = 1;
            
            pacificQue.add(new int[]{0,c});
            atlanticQue.add(new int[]{maxR-1,c});
        }
        
        bfs(pacificQue, pacific,heights);
        bfs(atlanticQue, atlantic, heights);
        
        for(int r=0; r< maxR; r++){
            for(int c=0; c <maxC;c++){
                if(pacific[r][c] ==1 && atlantic[r][c]==1){
                    returnVal.add(List.of(r,c));
                }
            }
        }
        return returnVal;
    }
    
    public void bfs(ArrayDeque<int[]> que, int[][] ocean, int[][] heights){
        while(que.size()>0){
            int n= que.size();
            for(int i=0; i<n;i++){
                int[] coordinate = que.poll();
                List<int[]> adjacent = getAdjacent(coordinate, ocean, heights);
                for(int[] newCoordinate : adjacent){
                    que.add(newCoordinate);
                    ocean[newCoordinate[0]][newCoordinate[1]] = 1;
                }
            }
        }
    }
    public List<int[]> getAdjacent(int[] coordinate, int[][] ocean, int[][] heights){
        int[] xdir = new int[]{0,0,1,-1};
        int[] ydir=  new int[]{1,-1,0,0};
        List<int[]> adjacents = new ArrayList();
        int maxR = heights.length;
        int maxC = heights[0].length;
        
        for(int i=0; i<4; i++){
            int newR = coordinate[0]+ xdir[i];
            int newC = coordinate[1]+ ydir[i];
            
            if(newR>=0 && newR< maxR && newC>=0 && newC< maxC && ocean[newR][newC] ==0 && heights[coordinate[0]][coordinate[1]] <= heights[newR][newC]){
                adjacents.add(new int[]{newR, newC});
            }
        }
        return adjacents;
    }
}