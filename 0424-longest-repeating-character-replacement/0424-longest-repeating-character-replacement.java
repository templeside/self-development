class Solution {
    public int characterReplacement(String s, int k) {
        int startIdx = 0;
        int longestSubstring = 0;
        int maxRepeatedCount = 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int endIdx = 0; endIdx< s.length(); endIdx++){
            char endChar = s.charAt(endIdx);
            map.put(endChar, map.getOrDefault(endChar,0)+1);

            int windowLength = endIdx-startIdx+1;
            
            maxRepeatedCount = Math.max(maxRepeatedCount, map.get(endChar));  //어차피 most frequent만 확인할 거라 char필요 없음.
		            //maxRepeatedChar는 바뀔 가능성이 없나??
            
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