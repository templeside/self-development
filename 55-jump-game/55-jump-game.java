class Solution {
    /*
    jump 할 수 있는지 없는지 체크를 해야 한다.
    brute force: 
        iterate using for loop.
        having boolean[] dp - checking how much can you do.
        i've done it before :0
        
    nums  = [2,3,1,1,4]
    i        ^
    j          ^
    dp[n] =  t t
    */
    public boolean canJump(int[] nums) {
        int n =nums.length;
        boolean[] dp= new boolean[n];
        dp[0] = true;
        
        for(int i=0; i< n; i++){
            for(int j=i+1; j<n && j<= i+nums[i]; j++){
                if(dp[i]){
                    dp[j]= true;
                }
            }
        }
        return dp[n-1];
    }
}