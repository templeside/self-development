class Solution {
    /**
    all of the subsequences are from left to right.
    and try to get the subsequences by iterating.
    
    backtrack as the nums.
    recursion(currIdx, nums)
    
    options - for(i = currIdx+1; i<n; i++){
        1 + recursion(i, nums);
    }
    
    return the best longest.
    
    ex) 0,1,0,3,2,3

    recursion(min, -1, [0,1,0,3,2,3])
        recursion(0, 0, [1,0,3,2,3])
            recursion(1, 1, [0,3,2,3])
                recursion(3, 3, [3,2,3])
                recursion(2, 4, [3,2,3])
            recursion(3, 3, [3,2,3])
            recursion(2, 4, [2,3])
            recursion(3, 5, [3])
        recursion(1, 1, [0,3,2,3])
        recursion(0, 2, [3,2,3])
        recursion(3, 3, [2,3])
        recursion(2, 4, [3])
        recursion(3, 5, [])
        
    **/
    public int lengthOfLIS(int[] nums) {
        Integer[] dp= new Integer[nums.length+1];
        int prevVal= Integer.MIN_VALUE;
        int currIdx= -1;
        return recursion(prevVal, currIdx, nums, dp)-1;
    }
    
    public int recursion(int prevVal, int currIdx, int[] nums, Integer[] dp){
        int n= nums.length;
        if(currIdx>= n)return 0;
        if(dp[currIdx+1] !=null)return dp[currIdx+1];
        
        int longest = 0;
        for(int i=currIdx+1; i< n; i++){
            if(prevVal < nums[i] )
                longest = Math.max(longest, recursion(nums[i], i, nums, dp));
        }
        dp[currIdx+1] = longest+1;
        return dp[currIdx+1];
    }
}