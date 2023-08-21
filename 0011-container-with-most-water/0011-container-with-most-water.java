class Solution {
    /*
    left right, comparison 
    calculating the area
    area = Math.max(left or right) * width
    keep update the area which is smaller
    */
    public int maxArea(int[] height) {
        int left =0;
        int right = height.length-1;
        int maxArea = 0;
        
        while(left<right){
            int h = Math.min(height[left], height[right]);
            int w = right-left;
            
            int area = h*w;
            maxArea = Math.max(maxArea, area);
            
            if(height[left]>height[right])
                right--;
            else
                left++;
        }
        return maxArea;
    }
}