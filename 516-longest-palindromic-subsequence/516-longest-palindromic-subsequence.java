class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i=0; i<n;i++)
            dp[i][i] = 1;
        
        for(int startIdx = n-1; startIdx>=0; startIdx--){
            for(int endIdx = startIdx+1; endIdx< n; endIdx++){
                if(s.charAt(startIdx) == s.charAt(endIdx))
                    dp[startIdx][endIdx] = 2+ dp[startIdx+1][endIdx-1];
                else
                    dp[startIdx][endIdx] = Math.max(dp[startIdx+1][endIdx], dp[startIdx][endIdx-1]);
            }
        }
        return dp[0][n-1];
    }
}