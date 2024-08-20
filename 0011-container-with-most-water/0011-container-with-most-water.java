class Solution {
    /*
    height = [1,8,6,2,5,4,8,3,7]
left          ^
right                         ^
    7
    */
    public int maxArea(int[] height) {
        int maxArea = 0;
        int leftIdx=0;
        int rightIdx = height.length-1;
        
        while(leftIdx<rightIdx){
            int width = rightIdx-leftIdx;
            int length = Math.min(height[leftIdx], height[rightIdx]);
            
            maxArea = Math.max(width * length , maxArea);
            
            if(height[leftIdx]< height[rightIdx]){
                leftIdx++;
            }else
                rightIdx--;
        }
        return maxArea;
    }
}