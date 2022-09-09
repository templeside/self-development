class Solution {
    /**
    1. find out the total sums to figure out which is the half of the total subset.
    which wee will target to look for.
    2. find the targetSum.
    how to find? there is a set, and comparing with the values that is partitioned by index,
    it can be a problematic thing.
    ex)
    1,5,11,5
    total sum = 22
    targetSum = 11.
    
    we are looking for the item by iterating.
    each index has two options: 
    1. including current value
    2. excluding current value
    
    comparing, try to reach to the targetSum step by step.
    dp[n][currSum] = true if found partition
    
    n/ currSum  0 1 2 3 4 5 6 7 8 9 10 11
    [1]         t t f f f f f f f f f  f
    [1,5]       t t f f f t t f f f f  f
    [1,5,11]    t t f f f t t f f f f  t
    [1,5,11,5]  t t f f f t t f f f t  t
    
    n/ currSum 0 1 2 3 4
    [1]        t t f f f 
    [1,2]      t t t t t
    [1,2,5]    
    
    r=1
    c=2
    dp[r][c] = dp[r-1][c] || dp[r][c-currVal]
    
    내가 한 방식은 unlimited일 때 한 것이다.
    어떻게 하면 unlimited가 아닌, one by one으로 가능할 것일까?
    option 1-> including
    option 2-> excluding
    **/
    
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for(int num: nums)
            totalSum +=num;
        if(totalSum%2!=0)return false;
        
        int targetSum = totalSum/2;
        int currIdx=0;
        int currSum=0;
        Boolean[][] dp = new Boolean[n][targetSum];
        return dfs(currIdx, currSum, targetSum, nums, dp);
    }
    /**
    1,5,11,5
    ^
    1| 0
    6| 0|
    17| 6| 
    11
    **/
    public boolean dfs(int currIdx, int currSum, int targetSum, int[] nums, Boolean[][]dp){
        if(currIdx>= nums.length || currSum> targetSum)return false;
        if(currSum == targetSum) return true;
        
        if(dp[currIdx][currSum]!=null)return dp[currIdx][currSum];
        
        
        
        boolean b1 = dfs(currIdx+1, currSum+nums[currIdx], targetSum, nums, dp);
        boolean b2 = dfs(currIdx+1, currSum, targetSum, nums, dp);
        
        dp[currIdx][currSum] = b1||b2;
        return dp[currIdx][currSum];
    }
}