class Solution {
    /*
    area = width * height
    width = right-left+1
    height = min(leftHeight, rightHeight);
    
    shift the bigger height
    
    */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        
        while(left<right){
            int currArea = (right-left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, currArea);
            
            if(height[left]< height[right])
                left++;
            else
                right--;
        }
        
        return maxArea;
    }
}