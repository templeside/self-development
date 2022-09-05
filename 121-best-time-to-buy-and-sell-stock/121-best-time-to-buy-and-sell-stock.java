class Solution {
    /**
    bruteforce: O(N^2).
    
    max profit = Math.max(curr- prev).
    for(int curr=0; i< n; i++){
        for(prev = curr-1; prev>=0; prev--)
            update max.
    }
    
    better solution?
    buying when cheapest, tracking down the cheapest way
    selling on a expensive way,
    
    we can track down cheapest day.
    while iterating, compare each current profit by each iteration.
    **/
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit= 0;
        int cheapest = prices[0];
        for(int curr=0; curr< n; curr++){
            int profit = prices[curr]- cheapest;
            if(profit> maxProfit)
                maxProfit= profit;
            
            cheapest = Math.min(cheapest, prices[curr]);
            
        }
        return maxProfit;
    }
}