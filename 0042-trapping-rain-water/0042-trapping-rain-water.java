class Solution {
    /*
    currWater = currWall - height
    currWall = Math.min(left, right)
    keep in track of left, right
    left[i] = leftMax of height[i]
    right[i] = rightMax of height[i]
    
height = [0,1,0,2,1,0,1,3,2,1,2,1]
left      0 0 1 1 2 2 2 2 3 3 3 3 
right     3 3 3 3 3 3 3 2 2 2 1 0
left[i] = Math.max(height[i-1], left[i-1])
right[i] = Math.max(height[i+1], left[i+1])
currWal = Math.min(left[i], right[i]);
    */
    public int trap(int[] height) {
        int n = height.length;
        int[] leftWall = new int[n];
        int[] rightWall = new int[n];
        
        for(int i=1; i<n; i++){
            leftWall[i] = Math.max(height[i-1], leftWall[i-1]);
        }
        for(int i=n-2; i>=0; i--){
            rightWall[i] = Math.max(height[i+1], rightWall[i+1]);
        }
        
        int waters = 0;
        for(int i=0; i<n;i++){
            int currWall = Math.min(leftWall[i], rightWall[i]);
            int currWater = currWall - height[i];
            waters = currWater>0? waters+currWater: waters;
        }
        return waters;
    }
}