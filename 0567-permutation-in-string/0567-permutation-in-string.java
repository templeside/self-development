class Solution {
    /*
    when increment:
        update map
        update matched(if map.get(key) == 0)
    when decrement: - decrement when window.length() == s2.length()
        true or false
        update map
        update matched
        if found permutation, return true
    */
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s1.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        int windowLeft = 0;
        int matched = 0;
        
        for(int windowRight=0; windowRight< s2.length(); windowRight++){
            char rightChar = s2.charAt(windowRight);
            if(map.containsKey(rightChar)){
                map.put(rightChar, map.get(rightChar)-1);
                if(map.get(rightChar)== 0)
                    matched ++;
            }
            
            int windowLength = windowRight - windowLeft +1;
            
            
            if(windowLength == s1.length()){
                if(matched == map.size())
                    return true;
                
                char leftChar = s2.charAt(windowLeft);
                if(map.containsKey(leftChar)){
                    if(map.get(leftChar)==0)
                        matched --;
                    map.put(leftChar, map.get(leftChar)+1);
                    
                }
                windowLeft++;
            }
        }
        return false;
    }
}