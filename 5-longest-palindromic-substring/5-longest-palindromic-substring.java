class Solution {
    /**
    bottom up things - 
    */
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] returnVal = new int[2];
        
        for(int i=0; i<n; i++)
            dp[i][i]= true;
        
        for(int startIdx=n-1; startIdx>=0; startIdx--){
            for(int endIdx = startIdx+1; endIdx<n; endIdx++){
                if(s.charAt(startIdx) == s.charAt(endIdx)){
                    if(endIdx-startIdx==1 || dp[startIdx+1][endIdx-1]){
                        dp[startIdx][endIdx] = true;
                        if(returnVal[1]-returnVal[0]< endIdx-startIdx){
                            returnVal[0] = startIdx;
                            returnVal[1] = endIdx;
                        }
                    }
                }
            }
        }
        return s.substring(returnVal[0], returnVal[1]+1);
    }
}