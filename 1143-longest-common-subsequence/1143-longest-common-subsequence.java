class Solution {
    /**
    subsequence including any messages.
    option 1 - matching
    option 2 - not matching.
    because it is subsequence - always matching is long.
    **/
    public int longestCommonSubsequence(String text1, String text2) {
        Integer[][] dp = new Integer[text1.length()][text2.length()];
        return recursion(text1,text2, 0,0, dp);
    }
    
    public int recursion(String text1, String text2, int idx1, int idx2, Integer[][] dp){
        if(idx1>= text1.length() || idx2>= text2.length()) 
            return 0;
        
        if(dp[idx1][idx2] !=null)
            return dp[idx1][idx2] ;
        
        
        if(text1.charAt(idx1) == text2.charAt(idx2))
            dp[idx1][idx2] = 1+recursion(text1, text2, idx1+1, idx2+1, dp);
        else{
            int s1 = recursion(text1, text2, idx1+1, idx2, dp);
            int s2 = recursion(text1, text2, idx1, idx2+1, dp);
            dp[idx1][idx2] =  Math.max(s1, s2);
        }
        return dp[idx1][idx2];
    }
}