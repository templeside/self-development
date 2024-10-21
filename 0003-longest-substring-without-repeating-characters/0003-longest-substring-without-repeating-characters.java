class Solution {
    /*
    sliding window
        increment:
            update without repeating chcaracters
            
            after removing the repeating chars
        decrement - when having duplicated chars
        
        update longest
    */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int endIdx = 0;
        int longest = 0;
        Set<Character> visited = new HashSet<>();
        
        for(int startIdx=0; startIdx<n; startIdx++){
            char currChar = s.charAt(startIdx);
            
            while(endIdx<= startIdx && visited.contains(currChar)){
                char endChar = s.charAt(endIdx);
                visited.remove(endChar);
                endIdx++;
            }
            visited.add(currChar);
            int windowSize = startIdx-endIdx+1;
            
            longest = Math.max(longest, windowSize);
        }
        return longest;
    }
}