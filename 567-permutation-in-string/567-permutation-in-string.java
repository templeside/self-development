class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> counter = new HashMap<>();
        
        for(char c: s1.toCharArray())
            counter.put(c, counter.getOrDefault(c, 0)+1);
        
        int windowStart=0;
        int matchedKey = 0;
        for(int windowEnd =0; windowEnd< s2.length(); windowEnd++){
            char charEnd = s2.charAt(windowEnd);
            if(counter.containsKey(charEnd)){
                counter.put(charEnd, counter.get(charEnd)-1);
                if(counter.get(charEnd)==0)
                    matchedKey++;
            }
            if(matchedKey == counter.size())
                return true;
            
            if(windowEnd-windowStart+1>=s1.length()){
                char charStart = s2.charAt(windowStart);
                windowStart++;
                if(counter.containsKey(charStart)){
                    if(counter.get(charStart)==0)
                        matchedKey--;
                    counter.put(charStart, counter.get(charStart)+1);
                }   
                
            }

        }
        return false;
    }
}