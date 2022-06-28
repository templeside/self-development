class Solution {
    public int longestPalindromeSubseq(String s) {
        int startIdx=0, endIdx=s.length()-1;
        Integer[][] dp = new Integer[s.length()][s.length()];
        return recursion(dp, s, startIdx, endIdx);
    }
    
    public int recursion(Integer[][] dp, String s, int startIdx, int endIdx){
        if(startIdx > endIdx)return 0;
        else if(startIdx ==endIdx) return 1;
        
        if(dp[startIdx][endIdx] !=null)return dp[startIdx][endIdx];// dp 이미 있을 때
        
        if(s.charAt(startIdx) == s.charAt(endIdx)){     //palindromic subsequence
            dp[startIdx][endIdx] = 2+ recursion(dp, s, startIdx+1, endIdx-1);
        }else{
            dp[startIdx][endIdx] = Math.max(recursion(dp, s, startIdx+1, endIdx), recursion(dp, s, startIdx, endIdx-1));
        }

        return dp[startIdx][endIdx];
    }
}