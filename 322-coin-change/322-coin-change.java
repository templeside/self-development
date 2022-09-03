class Solution {
    /**
    i can divide into subproblems.
    amount = [0, n] n is the goal of the amount.
    in this process, we would let you know how to reach to the coin amount we could get.
    
    dp[i] = less coin amount I can get.
    
    **/
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for(int i=1; i<=amount; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        
        for(int currAmount = 1; currAmount<= amount; currAmount++){
            for(int coinIdx=0; coinIdx<coins.length; coinIdx++){
                int coin = coins[coinIdx];
                if(currAmount>= coin && dp[currAmount-coin] != -1){
                    dp[currAmount] = Math.min(dp[currAmount], dp[currAmount-coin]+1 );
                }
            }
            dp[currAmount] = dp[currAmount] == Integer.MAX_VALUE? -1: dp[currAmount];
        }
        // for(int currAmount=1; currAmount<=amount; currAmount++)
        //     dp[currAmount] = dp[currAmount] == Integer.MAX_VALUE? -1: dp[currAmount];
        return dp[amount];
    }
}