class Solution {
    
    /**
height= 1 8 6 2 5 4 8 3 7
index   0 1 2 3 4 5 6 7 8
left      ^
right               ^
    8-1 = 7 * 7 
    
    **/
    public int maxArea(int[] height) {
        int left=  0;
        int right = height.length-1;
        
        int maxArea = 0;
        
        while(left< right){
            int currArea = (right-left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, currArea);
            
            int rightVal = height[right];
            int leftVal = height[left];
            
            if(leftVal< rightVal){
                left++;
            }else
                right--;
        }
        return maxArea;
    }
}