class Solution {
    /**
amount= 0 1   2   3
2       0 INF 1   INF+1
3       0 INF INF 1
5       0 INF INF INF
MIN     0 INF 1   1
return arr[length]
    **/
    public int coinChange(int[] coins, int amount) {
        if(amount ==0)return 0;
        long[] amountArr = new long[amount+1];
        
        for(int i=0; i< amount+1; i++){
            amountArr[i] = Integer.MAX_VALUE;
            for(int coin: coins){
                int complement = i-coin;
                if(complement==0) //2,2
                    amountArr[i] = 1;
                else if(complement>0){
                    amountArr[i] = Math.min(amountArr[i], amountArr[complement]+1);
                }
            }
        }
        return amountArr[amount] >= Integer.MAX_VALUE? -1: (int)amountArr[amount];
    }
}