class Solution {
    /*
    starting from back
    count up the min number
    arr[i]+1 == arr[i+k] 
    arr[0]
                        
    nums = [2,3,1,1,4]
    dp   =  5 5 5 5 5
    i       ^
    j         ^
    newI = 1
    */
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, n+1);
        dp[0] = 0;
        for(int i=0; i<n; i++){
            int jumps = nums[i];
            
            for(int j=1; j<= jumps; j++){
                int newI = i+ j;
                if(newI>=n)
                    continue;
                dp[newI] = Math.min(dp[i]+1, dp[newI]);
            }
        }
        return dp[n-1];
    }
}