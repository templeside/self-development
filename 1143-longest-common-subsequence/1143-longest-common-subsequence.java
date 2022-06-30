class Solution {
    /**
    abcde
    ^
    ace
    ^
    s1 abcde, s2 ace -> s1(a) == s2(a). matched.
    s1 bcde,  s2 ce ->  s1(b) != s2(c). not matched.
    s1 bcde,  s2 e ->   s1(b) != s2(e). not matched || s1 cde, s2 ce -> s1(c) != s2(c). not matched.
        
    moving to the index if the curr index is equal. otherwise, looking for other ways to do.
    changing variables - s1Idx, s2Idx
    dp[s1Idx][s2Idx] = maxval? nope. count should be.
    
    dp[i][j] = dp[i-1][j-1];        //when matching
    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);    //when not matching.
    **/
    public int longestCommonSubsequence(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        
        for(int s1Idx=1; s1Idx<= s1.length(); s1Idx++){
            for(int s2Idx=1; s2Idx<= s2.length(); s2Idx++ ){
                if(s1.charAt(s1Idx-1)== s2.charAt(s2Idx-1))
                    dp[s1Idx][s2Idx] = 1+dp[s1Idx-1][s2Idx-1];
                else{
                    int c1 = dp[s1Idx-1][s2Idx];
                    int c2 = dp[s1Idx][s2Idx-1];
                    dp[s1Idx][s2Idx] = Math.max(c1, c2);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}