class Solution {
/**
The water containing by the min(left wall, right wall)- currheight.

which means I need to check the left and right wall.

1. find the left wall
2. find the right wall
3. find all waters. min(left,right)- height

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
left             0 0 1 1 2 2 2 2 3 3 3 3
right            3 3 3 3 3 3 3 2 2 2 1 0
water                1   1 2 1 

Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
**/
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i=1; i< n; i++){
            left[i] = Math.max(left[i-1], height[i-1]);
        }
        for(int i=n-2; i>=0; i--){
            right[i] = Math.max(right[i+1], height[i+1]);
        }
        
        int count = 0;
        for(int i=0; i<n;i++){
            int smallerWall = Math.min(right[i], left[i]);
            if(smallerWall> height[i])
                count += smallerWall-height[i];
        }
        return count;
    }
}