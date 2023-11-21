class Solution {
    public int numSquares(int n) {
        // set to arbitrarily high value, 0x3f3f3f3f was chosen here which is approximately 10^9, any sufficiently large value can work here
        int [] dp = new int [n + 1];
        Arrays.fill(dp, 0x3f3f3f3f);
        dp[0] = 0;

        // we only need to loop up to the square root of the number so we don't exceed it
        for (int i = 1; i * i <= n; i++) {
            int cur = i * i;
            for (int j = cur; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - cur] + 1);
            }
        }
        return dp[n];
    }
}