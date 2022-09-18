class Solution {
    /**
    s = "abcabcbb"
start      ^
end      ^
set{a b}
largest =2
    **/
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int windowEnd=0;
        int longest = 0;
        for(int windowStart = 0; windowStart<s.length(); windowStart++){
            char currChar= s.charAt(windowStart);
            while(windowEnd<windowStart && set.contains(currChar)){
                set.remove(s.charAt(windowEnd));
                windowEnd++;
            }
            set.add(currChar);
            longest = Math.max(longest, windowStart-windowEnd+1);
        }
        return longest;
    }
}