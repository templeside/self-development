class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] returnIdx=  new int[2];
        
        for(int i=0; i< n; i++)
            dp[i][i] = true;
        
        for(int startIdx= n-1; startIdx>=0 ; startIdx--){
            for(int endIdx= startIdx+1; endIdx<n; endIdx++){
                if(s.charAt(startIdx) == s.charAt(endIdx)){
                    if(endIdx-startIdx ==1 || dp[startIdx+1][endIdx-1]){
                    dp[startIdx][endIdx] = true;
                    if(returnIdx[1]-returnIdx[0]< endIdx-startIdx){
                        returnIdx[0] = startIdx;
                        returnIdx[1] = endIdx;
                    }
                    }
                }
            }
        }
        return s.substring(returnIdx[0], returnIdx[1]+1);
    }
}