class Solution {
    /*
    matched
    Map<Character, Integer> 
    
    incrment:
        add val
        if all matched
            add to returnVal
    shrink - when length is same
        remove from the original values
        shift end
    */
    public List<Integer> findAnagrams(String s, String p) {
        int endIdx= 0;
        Map<Character ,Integer> map = new HashMap<>();
        for(char c: p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        List<Integer> result = new ArrayList<>();
        int matched = 0;
        for(int startIdx=0; startIdx< s.length(); startIdx++){
            char currChar = s.charAt(startIdx);
            if(map.containsKey(currChar)){
                map.put(currChar, map.get(currChar)-1);
                if(map.get(currChar) == 0)
                    matched ++;
                
                if(matched == map.size())
                    result.add(endIdx);
            }
            
            while(startIdx-endIdx+1 ==p.length()){
                char endChar = s.charAt(endIdx);
                if(map.containsKey(endChar)){
                    if(map.get(endChar) == 0)
                        matched--;
                    map.put(endChar, map.get(endChar)+1);
                }
                endIdx++;
            }
        }
        return result;
    }
}