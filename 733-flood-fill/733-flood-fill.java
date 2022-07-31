class Solution {
    /**
    1. find the sourceColor,
    2. starting from the sourceColor rows and cols, get adjacent which has same color as sourceColor
    3. add the coordinates and add to iterator.
    4. 
    **/
    class coordinate{
        int r;
        int c;
        int[][] map;
        public coordinate(int row, int col, int[][] image){
            r = row;
            c = col;
            map = image;
        }
        public List<coordinate> getAdjacencies(int sourceColor){
            int[] rDirection = new int[]{0,0,1,-1};
            int[] cDirection = new int[]{1,-1,0,0};
            int maxR=  map.length;
            int maxC = map[0].length;
            List<coordinate> adjacencies = new ArrayList<>();
            
            for(int i=0; i< 4; i++){
                int newR= r+rDirection[i];
                int newC = c+ cDirection[i];
                
                if(newR>=0 && newR< maxR && newC>=0 && newC< maxC && map[newR][newC] == sourceColor)
                    adjacencies.add(new coordinate(newR, newC, map));
            }
            return adjacencies;
        }
        public void setColor(int color){
            map[r][c] = color;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int sourceColor = image[sr][sc];
        if(sourceColor == color) return image;
        coordinate currNode = new coordinate(sr, sc, image);
        
        ArrayDeque<coordinate> bfsIterator = new ArrayDeque<>();
        bfsIterator.add(currNode);
        
        while(bfsIterator.size()>0){
            currNode = bfsIterator.poll();
            currNode.setColor(color);
            for(coordinate adjacent: currNode.getAdjacencies(sourceColor)){
                bfsIterator.add(adjacent);
            }
        }
        return image;
    }
}