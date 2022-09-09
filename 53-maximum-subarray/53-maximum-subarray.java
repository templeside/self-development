class Solution {
    /**
global variable로 하나만  있었으면 되었네 ㅅㅂ....
    **/
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        
        int[] dp = new int[n];
        dp[0] = nums[0];
        int maxSub = nums[0];
        
        for(int i=1; i< n;i++){
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            maxSub = Math.max(dp[i], maxSub);
        }
        return maxSub;
    }
}