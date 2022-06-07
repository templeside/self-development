class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> anagrams = new ArrayList<>();
        int windowStart = 0;
        int matchedKey = 0;
        HashMap<Character, Integer> counter = new HashMap<>();
        
        for(char c: p.toCharArray()){
            counter.put(c, counter.getOrDefault(c, 0)+1);
        }
        
        for(int windowEnd =0; windowEnd<s.length(); windowEnd++ ){
            char endChar = s.charAt(windowEnd);
            if(counter.containsKey(endChar)){
                counter.put(endChar, counter.get(endChar)-1);
                if(counter.get(endChar)== 0)
                    matchedKey++;
            }
            
            if(matchedKey == counter.size())
                anagrams.add(windowStart);
            
            if(windowEnd-windowStart+1>=p.length()){
                char startChar = s.charAt(windowStart);
                if(counter.containsKey(startChar)){
                    if(counter.get(startChar)== 0)
                        matchedKey--;
                    counter.put(startChar, counter.get(startChar)+1);
                    
                }
                windowStart++;
            }
        }
        return anagrams;
    }
}