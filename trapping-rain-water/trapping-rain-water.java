class Solution {
    public int trap(int[] height) {
        int watercount = 0;
        int left = 0;
        int right = height.length-1;
        int leftMax = height[left];
        int rightMax = height[right];
        
        while(left<right){
            if(leftMax<rightMax){       //when left

                watercount += leftMax-height[left];
                left ++;
                leftMax = Math.max(height[left], leftMax);                

            }else{
                
                watercount += rightMax-height[right];
                right --;
                rightMax = Math.max(height[right], rightMax);
            }
            
        }
        return watercount;
    }
}