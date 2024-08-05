class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int currSum = 0;
        int minSize = nums.length+1;
        
        int windowTail = 0;
        for(int windowStart=0; windowStart< nums.length; windowStart ++){
            currSum += nums[windowStart];
            
            while(currSum>= target){
                minSize = Math.min(minSize, windowStart-windowTail+1);
                currSum -= nums[windowTail];
                windowTail++;
            }
        }
        return minSize == nums.length+1? 0 : minSize;
    }
}