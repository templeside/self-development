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
    **/
    public int longestCommonSubsequence(String s1, String s2) {
        if(s1.length()<=0 || s2.length()<=0)return 0;
        Integer[][] dp = new Integer[s1.length()][s2.length()];
        return recursion(dp, s1, s2, 0, 0);
    }
    public int recursion(Integer[][] dp, String s1, String s2, int s1Idx, int s2Idx){
        if(s1Idx>=s1.length() || s2Idx>= s2.length())return 0;
        
        if(dp[s1Idx][s2Idx]!=null)return dp[s1Idx][s2Idx];
        
        if(s1.charAt(s1Idx) == s2.charAt(s2Idx)) 
            dp[s1Idx][s2Idx] = 1+ recursion(dp, s1,s2, s1Idx+1, s2Idx+1);
        else{
            dp[s1Idx][s2Idx] = Math.max(recursion(dp, s1, s2, s1Idx+1, s2Idx), recursion(dp, s1, s2, s1Idx, s2Idx+1));
        }
        
        return dp[s1Idx][s2Idx];
    }
}