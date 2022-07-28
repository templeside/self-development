class Solution {
    /**
    need to find the max area I could get. starting from the most outward would be great to have.
    
    having two pointers, trying to find a max value I could get.
    
    maxVal = 0;
    
    shifting the smaller value. as much as I could.
    
                 0 1 2 3 4 5 6 7 8
Input: height = [1,8,6,2,5,4,8,3,7]
left               ^
right                            ^
curArea = 7*
Output: 49

    **/
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int maxArea = 0;
        while(left<right){
            int leftVal = height[left];
            int rightVal = height[right];
            
            if(leftVal> rightVal){
                maxArea = Math.max(maxArea, rightVal * (right-left));
                right --;
            }else{
                maxArea = Math.max(maxArea, leftVal * (right-left));
                left++;
            }
        }
        return maxArea;
    }
}