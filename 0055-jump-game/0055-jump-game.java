class Solution {
    /*
    starting from backwards, check the valid hardware, do the items.
    it is called 
                        
        nums = [2,3,1,1,4]
jumpable     = [          T]
    */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n-1] = true;
        for(int i= n-1; i>=0 ; i--){
            int jump = nums[i];
            //  if(dp[i+jump] == true)
                // update it
            for(int j=1; j<= jump; j++){
                int newIdx = i+j;
                if(newIdx< n &&  dp[newIdx] ==true){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}