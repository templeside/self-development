class Solution {
    /*
    max day
    by shifting, find a best way.
    
    brute force way - 
    two pointers, left, right
    for(int right=0; i< n; i++)
        for(int left =0 left<right; left++)
            find max profit, update
    time - O(N^2)
    space - O(1)
    
    better approach? 
    
    prices = [7,1,5,3,6,4]
buy           ^
sell          ^
    
minSell), maxBuy)
    
    increment: update sell
    decrement: update buy.
    
    */
    public int maxProfit(int[] prices) {
        int minBuy = prices[0];
        int maxProfit = 0;
        
        int buy = 0;
        for(int sell=0; sell< prices.length; sell++){
        // increment: update sell
            int sellPrice = prices[sell];
        // decrement: update buy.            
            while(minBuy> prices[sell]){
                minBuy = Math.min(minBuy, prices[sell]);
            }
            maxProfit = Math.max(sellPrice-minBuy, maxProfit);
        }
        return maxProfit;
    }
}