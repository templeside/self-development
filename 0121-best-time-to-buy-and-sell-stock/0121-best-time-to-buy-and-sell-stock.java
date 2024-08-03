class Solution {
    /*
    [7,1,5,3,6,4]
buy  ^
sell ^

max 7
min 7
profit 0
max date, min date update while reaching end
why this is dynamic programming?
    */
    public int maxProfit(int[] prices) {
        int max = prices[0];
        int min = prices[0];
        int maxProfit = max-min;
        
        for(int i=0; i< prices.length; i++){
            min = Math.min(prices[i], min);
            int diff = prices[i]-min;
            maxProfit = Math.max(maxProfit, diff);
        }
        return maxProfit;
    }
}