class Solution {
    /*
    increment - 
        decrement - when found the visited already
        
        update length
        add visited
    */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> visited = new HashSet<>();
        int endIdx=0;
        int n = s.length();
        int longest = 0;
        
        for(int startIdx=0; startIdx< n; startIdx++){
            char currChar = s.charAt(startIdx);
            while(visited.contains(currChar)){
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