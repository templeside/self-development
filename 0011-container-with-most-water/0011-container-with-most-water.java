class Solution {
    /*
    area = width * height
    width = right-left+1
    height = Math.min(left, right)
    area = width * height
    update area
    */
    public int maxArea(int[] height) {
        int max = 0;
        int left=0;
        int right = height.length-1;
        
        while(left<right){
            int width = right-left;
            int currHeight = Math.min(height[left], height[right]);
            int currArea = currHeight * width;
            max = Math.max(max, currArea);
            
            if(height[left]< height[right]){
                left++;
            }else
                right--;
        }
        return max;
    }
}