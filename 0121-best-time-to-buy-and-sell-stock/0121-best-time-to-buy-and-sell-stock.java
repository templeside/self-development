class Solution {
    /*
    two for loops
    one is for sell
        one is for buy
    time complexity of two.
    
    better solution...
    what if keeping the min selling stock?
    
    for(iteration)
        keep min
        update profit
    */
    public int maxProfit(int[] prices) {
        int minBuy = prices[0];
        int maxProfit = 0;
        
        for(int sell = 1;sell< prices.length; sell++){
            minBuy = Math.min(minBuy, prices[sell]);
            maxProfit = Math.max(maxProfit, prices[sell]-minBuy);
        }
        return maxProfit;
    }
}