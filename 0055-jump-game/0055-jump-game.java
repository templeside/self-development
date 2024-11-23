class Solution {
    /*
    by approaching from back, check available to reach.
                    t
    nums = [2,3,1,1,4]
    starting from last index checking vailable to reach out.
    
    for(int i, i < i+ nums[i]; i++)
        dp[i] = possible values
    */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n-1] = true;
        
        for(int i=n-1; i>=0; i--){
            int jumpby = i+nums[i];
            for(int nextIdx = 1; nextIdx<= jumpby && nextIdx< n; nextIdx++){
                if(dp[i] == true)
                    break;
                if(dp[nextIdx] == true){
                    dp[i] = true;
                }
            }
        }
        return dp[0];
    }
}