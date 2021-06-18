class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length<0) return 0;
        
        int currSum = nums[0];
        int totalSum = nums[0];
        for(int i=1; i<nums.length;i++){
            int currInt = nums[i];
            currSum = currSum + currInt > currInt? currSum+currInt:currInt;
            totalSum = totalSum > currSum? totalSum: currSum;
        }
        return totalSum;
    }
}