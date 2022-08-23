class Solution {
    /**
Input: amount = 5, coins = [1,2,5]
Output: 4

dp[coins][amount] = count... which means need to add the values..?

coins/ amount   0   1   2   3   4   5
{1}             1   1   1   1   1   1
{1,2}           1   1   2   2   3   3
{1,2,5}         1   1   2   2   3   4

dp[r][c]=  dp[r-1][c] + dp[r][c-currWeight]

Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1

    **/
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i=0; i<n; i++){
            dp[i][0] = 1;
        }
        
        for(int r=0; r<n; r++){
            for(int currAmount=1; currAmount<= amount; currAmount++){
                int currCoinAmount = coins[r];
                int excludingCount =0, includingCount =0;
                
                if(r>0){ // combination with prev.
                    excludingCount = dp[r-1][currAmount];
                }
                if(currAmount>= currCoinAmount){
                    includingCount = dp[r][currAmount-currCoinAmount];
                }
                dp[r][currAmount] = excludingCount+includingCount;
            }
        }
        return dp[n-1][amount];
    }
}