class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];
        return backtrack(0, s, wordSet, memo);
    }
    
    public boolean backtrack(int currstart, String s, Set<String> wordSet, Boolean[] memo){
        if(currstart == s.length())return true;
        if(memo[currstart]!=null)return memo[currstart];
        
        for(int end=currstart+1; end<= s.length(); end++){
            if(wordSet.contains(s.substring(currstart, end))&&backtrack(end, s, wordSet,memo)){
                return memo[currstart] = true;
            }
        }
        
        return memo[currstart] = false;
    }
}