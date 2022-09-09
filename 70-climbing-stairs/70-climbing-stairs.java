class Solution {
    /**
    can be divided upto the things......
    dp[n] = ways to the n stairs
    dp[n] = dp[n-1]+ dp[n-2].
    
    option: 1,2
    climb 1
    climb 2
    
    recursion(currStair, endStair, dp)
    
    **/
    public int climbStairs(int n) {
        // int[]dp = new int[n+1];
        
        // dp[0] = 1;
        // dp[1] = 1;
        int twoPrev = 1;    //i-2
        int onePrev = 1;    //i=1
        
        
        
        for(int i=2; i<=n; i++){
            int currStep = twoPrev+onePrev;
            twoPrev = onePrev;
            onePrev = currStep;
        }
        return onePrev;
    }
}