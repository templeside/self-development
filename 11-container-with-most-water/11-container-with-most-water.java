class Solution {
    /**          0 1 2 3 4 5 6 7 8
    height(n) = [1 8 6 2 5 4 8 3 7]
left                 ^
right                        ^
distance = 49
maxSum=0;
1. if(leftVal< rightVal)
    maxSum reinitialize
    left++
    
2. else
    maxSum reinitialize
    right++
    
output = max( min(max(left),max(right)) *right-left)
    **/
    
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxSum = 0;
        
        while(left<right){
            int leftVal = height[left];
            int rightVal = height[right];
            
            if(leftVal<rightVal){
                maxSum = Math.max(maxSum, Math.min(leftVal, rightVal) * (right-left));
                left++;
            }else{
                maxSum = Math.max(maxSum, Math.min(leftVal, rightVal) * (right-left));
                right--;
            }
        }
        
        return maxSum;
    }
}