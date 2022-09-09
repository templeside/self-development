class Solution {
    /**
    robber should not have two adjacent houses.
    there are n houses, and need to get the maximum profit.
    cuz we need the maximum profit, we look forward to get a max profit as much as I can do from 0 to n house.
    so we need a step by step max profit, so we need dynamic programming to use.
    
    dp[n] = max profit i can get.
    dp[n] = Math.max(dp[n-1], dp[n-2]+nums[n])
    **/
    public int rob(int[] nums) {
        int n = nums.length;
        int[]dp = new int[n];

        if(n ==1)return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<n;i++)
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        
        return dp[n-1];
    }
}