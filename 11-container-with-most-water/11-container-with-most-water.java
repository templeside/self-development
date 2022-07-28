class Solution {
    /**    
                 0 1 2 3 4 5 6 7 8
Input: height = [1,8,6,2,5,4,8,3,7]
left               ^
right                            ^
curArea = 7*
Output: 49

    **/
    public int maxArea(int[] height) {
        int leftIdx = 0, rightIdx = height.length-1;
        int maxArea = 0;
        while(leftIdx<rightIdx){
            int leftVal = height[leftIdx];
            int rightVal = height[rightIdx];
            
            if(leftVal> rightVal){
                maxArea = Math.max(maxArea, rightVal * (rightIdx-leftIdx));
                rightIdx --;
            }else{
                maxArea = Math.max(maxArea, leftVal * (rightIdx-leftIdx));
                leftIdx++;
            }
        }
        return maxArea;
    }
}