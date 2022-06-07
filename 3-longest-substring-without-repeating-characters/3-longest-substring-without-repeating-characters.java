class Solution {
    /**
    first intuition, figured out I need to count the number of each chars.
    if found duplication, shrink the window size.    
    **/
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> counter = new HashMap<>();
        int windowStart = 0;
        int longest = 0;
        
        for(int windowEnd = 0; windowEnd< s.length(); windowEnd++){
            char endChar = s.charAt(windowEnd);
            counter.put(endChar, counter.getOrDefault(endChar, 0)+1);
            
            while(counter.get(endChar)>1){
                char startChar = s.charAt(windowStart);
                counter.put(startChar, counter.get(startChar)-1);
                windowStart++;
            }
            longest = Math.max(longest, windowEnd-windowStart+1);
        }
        return longest;
    }
}