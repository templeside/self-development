class Solution {
    /*
    0 1 2 3 4 5 6 7 8 9 10 11
    1 
    
    by iterating, we can find is it valid or not
    1 2 5
    dp[i] = dp[i-coin[j]]
    dp = min num of coins to reach that val.
    */
    public int coinChange(int[] coins, int amount) {
        if(amount ==0)return 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0]=0;
        
        for(int i=0; i<=amount; i++){
            for(int j=0;j<coins.length; j++){
                int coin = coins[j];
                if(i-coin >=0){
                    dp[i] = Math.min(dp[i-coin]+1,dp[i]) ;
                }
            }
        }
        
        return dp[amount] == amount+1? -1 : dp[amount];
    }
}