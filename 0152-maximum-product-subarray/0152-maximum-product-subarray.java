class Solution {
    /*
    keep track of min, max
    
    for iteration
        if posoitive
            update min = min(prevMin * currNum, currNum)
            update max = max(prevMax * currNum, currNum)
        if negative
            update min = min(prevMax * currNum, currNum)
            update max = max(prevMax * currNum, currNum)
        update maxProduct = max(maxProduct, max)
    */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n ==1)
            return nums[0];

        int[][] dp = new int[n][2]; //dp[i][0] == min, dp[i][1] == max
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int maxProd = nums[0];
        
        for(int i=1; i< n; i++){
            int currNum = nums[i];
            
            int prevMin = dp[i-1][0];
            int prevMax = dp[i-1][1];
            int currMin;
            int currMax;
            
            if(currNum>=0){
                currMin= Math.min(prevMin * currNum, currNum);
                currMax = Math.max(prevMax * currNum, currNum);
            }
            else{
                currMin = Math.min(prevMax * currNum, currNum);
                currMax = Math.max(prevMin * currNum, currNum);
            }
            
            dp[i][0] = currMin;
            dp[i][1] = currMax;
            
            maxProd = Math.max(maxProd, currMax);
        }
        
        
        return maxProd;
    }
}