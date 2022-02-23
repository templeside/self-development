class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        // 1. backtrack 
        // 2. sort and make to string.
        
        // or backtracking is going with the words.
        // backtrack(word, curr idx, s, wordSet)
        Set<String> wordSet = new HashSet(wordDict);
        List<String> returnVal = new ArrayList<>();
        
        backtrack("", 0, s, wordSet, returnVal);
        
        return returnVal;
    }
    public void backtrack(String currString, int currIdx, String s, Set<String> wordSet, List<String> returnVal){
        if(currIdx>= s.length()){
            if(currIdx== s.length())
                returnVal.add(currString.substring(0,currString.length()-1));
            return;
        }
        
        for(int end = currIdx+1; end<=s.length();end++){
            String substr = s.substring(currIdx,end);
            if(wordSet.contains(substr)){
                
                currString += substr+ " ";
                
                backtrack(currString, end, s, wordSet, returnVal);
                currString = currString.substring(0, currString.length()-substr.length()-1);
            }
        }
        
        
    }
}