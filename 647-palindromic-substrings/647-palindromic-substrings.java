class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count =0;
        
        for(int i=0; i< n; i++){
            dp[i][i] = true;
            count++;
        }
        
        for(int startIdx = n-1; startIdx>=0; startIdx--){
            for(int endIdx= startIdx+1; endIdx< n; endIdx++){
                if(s.charAt(startIdx) == s.charAt(endIdx)){
                    if(endIdx-startIdx ==1 || dp[startIdx+1][endIdx-1]){
                        dp[startIdx][endIdx] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}