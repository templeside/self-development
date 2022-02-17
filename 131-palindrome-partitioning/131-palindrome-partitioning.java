class Solution {
    public List<List<String>> partition(String s) {
        // given a string s, return every string that is palindrome.
        // backtracking???? Can I use that??
        
        // - need to have the idendifier, string, current array, d
        // backtracking()
        
        List<List<String>> returnVal = new ArrayList<>();
        backtracking(0, s, returnVal, new ArrayList<>());
        return returnVal;
    }
    public void backtracking(int start, String s, List<List<String>> returnVal, List<String> currVal){
        if(start >= s.length()) returnVal.add(new ArrayList(currVal));
        
        for(int end = start+1; end<=s.length();end++){
            if(isPalindrome(s.substring(start,end))){
                currVal.add(s.substring(start,end));
                backtracking(end, s, returnVal, currVal);
                currVal.remove(currVal.size()-1);
            }
                
        }
        
        // 1. first get the range of the characters.
        // 2. if it is valid, go ahead.
        //     3. add the value before calling the duplicate function.
        //     4. after done calling, going back to previous candidates.
    }
    
    public boolean isPalindrome(String s){
        for(int i=0; i< s.length()/2; i++){
            int reversed = s.length()-1-i;
            if(s.charAt(i)!=s.charAt(reversed))
                return false;
        }
        return true;
    }
}