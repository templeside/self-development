class Solution {
    /*
    first, need to update the max area of water.
    I need to look for the weater with container.
    
    water = width * height.
    width = windowEnd - windowStart
    height = Math.min(height[windowEnd, windowStart])
    
    update the area
    shifting the smaller height value index.
    */
    public int maxArea(int[] height) {
        int maxArea = 0;
        int n = height.length;
        
        int windowStart = 0;
        int windowEnd = n-1;
        
        while(windowStart<windowEnd){
            int currWidth = windowEnd-windowStart;
            int currHeight = Math.min(height[windowEnd], height[windowStart]);
            int currArea = currWidth * currHeight;
            
            maxArea = Math.max(currArea, maxArea);
            
            if(height[windowStart]< height[windowEnd])
                windowStart++;
            else
                windowEnd--;
        }
        return maxArea;
    }
}