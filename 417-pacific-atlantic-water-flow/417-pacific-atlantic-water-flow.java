class Solution {
    /**
    find all of the pacific Ocen, atlantic Ocean locations.
    find duplicated places that are available.
    
    1. initiate pacific ocean matrix, atlantic ocean matrix.
    2. from the pacific ocean matrix, find out as much as it could.
    3. from the atlantic ocean matrix, find out as much as it could.
    4. compare atlantic ocean and pacific ocean. 
    5. returnthe pacificAtlantic coordinates.
    **/
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rMax = heights.length, cMax = heights[0].length;
        List<List<Integer>> returnVal = new ArrayList<>();
        

        Queue<int[]> pacificIterator = new LinkedList<>();
        Queue<int[]> atlanticIterator = new LinkedList<>();
        for(int r= 0; r<rMax; r++){
            pacificIterator.add(new int[]{r,0});
            atlanticIterator.add(new int[]{r, cMax-1});
        }
        for(int c=0; c< cMax; c++){
            pacificIterator.add(new int[]{0,c});
            atlanticIterator.add(new int[]{rMax-1, c});
        }

        int[][] pacific = bfs(heights, pacificIterator);
        int[][] atlantic = bfs(heights, atlanticIterator);
        
        for(int r=0; r< rMax; r++){
            for(int c=0; c< cMax; c++){
                if(pacific[r][c]==1 && atlantic[r][c]==1)
                    returnVal.add(List.of(r,c));
            }
        }
        return returnVal;
    }
    
    // 0 - not visited, -1 - notValid, 1- valid.
    public int[][] bfs(int[][] heights, Queue<int[]> iterator){
        int[]rDir = new int[]{0,0,1,-1};
        int[] cDir = new int[]{1,-1, 0,0};
        int rMax = heights.length;
        int cMax = heights[0].length;
        int[][] map = new int[rMax][cMax];
        
        while(iterator.size()>0){
            int[] coordinate =iterator.poll();
            int r = coordinate[0];
            int c=  coordinate[1];
            map[r][c] = 1;
            
            //get the adjacencies.
            for(int i=0; i<4; i++){
                int newR = r+ rDir[i];
                int newC = c+ cDir[i];
                if(newR>=0 && newC>=0 && newR< rMax && newC< cMax && map[newR][newC] ==0 && heights[r][c] <= heights[newR][newC]){
                    map[newR][newC] = 1;
                    iterator.add(new int[]{newR,newC});
                }
            }
        }
        return map;
    }
}