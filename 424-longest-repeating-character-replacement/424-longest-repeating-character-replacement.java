class Solution {
    /**
    having the two pointer, start, end point to track on the character.
    
    having the slidingWindow  - having the updating the k.
    
    hashmap으로 업데이트 maxRepeatedCount 업데이트 하면 된다.
    그러면 maxSubstring 찾는 거는 ???? Math.max(windowEnd-windowStart+1) 하면 된다.
    
    그리고 k는????? shrink condition: len(current window) - maxRepeatedCount < k.
    
    keep updating max repeated count를 미리미리 해 주는 것!
    
    "AABABBA" k=1
start^
end      ^

map={A- 3, B-2}

windowLength = 4
longestSubstring = 4
maxRepeatedCount = 3


    **/
    public int characterReplacement(String s, int k) {
        int startIdx = 0;
        int longestSubstring = 0;
        int maxRepeatedCount = 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int endIdx = 0; endIdx< s.length(); endIdx++){
            char endChar = s.charAt(endIdx);
            map.put(endChar, map.getOrDefault(endChar,0)+1);

            int windowLength = endIdx-startIdx+1;
            
            maxRepeatedCount = Math.max(maxRepeatedCount, map.get(endChar));
            while(windowLength - maxRepeatedCount>k){
                char startChar = s.charAt(startIdx);
                map.put(startChar, map.get(startChar)-1);
                startIdx++;
                windowLength = endIdx-startIdx+1;
            }
            
            longestSubstring = Math.max(windowLength, longestSubstring);
        }
        return longestSubstring;
    }
}