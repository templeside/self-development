class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = prices[0];
        int maxprofit = 0;
        
        for(int i=0;i<prices.length;i++){
            if(min>prices[i]){
                max = prices[i];
                min = prices[i];
            }
            else{
                max = Math.max(max,prices[i]);
            }
            maxprofit = Math.max(maxprofit, max-min);
        }
        return maxprofit;
    }
}