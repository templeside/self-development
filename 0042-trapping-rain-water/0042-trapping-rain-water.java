class Solution {
    /*
    area = width * height
    area = 1 * Math.min(left, right) - currHeight
    
    add all the value.
    
    height = [0,1,0,2,1,0,1,3,2,1,2,1]
    leftMax   0 1 1 2 2 2 2 3 3 3 3 3
    rightMax                            
    
    leftMax = Math.max(height[i], leftMax[i-1])
    rightMax = Math.max(height[i], rightMax[i+1])
    
    height = Math.min(leftMax[left-1], rightMax[right+1]) - currHeight
    
    algo:
    // 1. update leftMax
    // 2. update rightMax
    // 3. calculate height & update area
    */
    public int trap(int[] height) {
        int totalArea = 0;
        int n = height.length;
        
        // 1. update leftMax
        int[] leftMax = new int[n];
        for(int i=0; i< n; i++){
            if(i ==0){
                leftMax[i] = height[i];
                continue;
            }
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        // 2. update rightMax
        int[] rightMax = new int[n];
        for(int i=n-1; i>=0; i--){
            if(i ==n-1){
                rightMax[i] = height[i];
                continue;
            }
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        // 3. calculate height & update area
        for(int i=1; i< n-1; i++){
            int minWall = Math.min(leftMax[i-1], rightMax[i+1]);
            if(minWall> height[i]){
                int currArea = minWall-height[i];
                totalArea += currArea;
            }
        }
        
        return totalArea;
    }
}