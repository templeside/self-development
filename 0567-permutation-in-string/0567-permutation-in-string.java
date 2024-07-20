class Solution {
    /*
    when increment:
        update Frequency
        update matched(if map.get(key) == 0)
    when decrement: - decrement when window.length() == s2.length()
        true or false
        update s1Frequency
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
            
            // System.out.println(map.entrySet());
            
            int length = windowRight - windowLeft +1;
            //decrement when length is same 
            // System.out.println(s2.substring(windowLeft, windowRight+1));
            // System.out.println(length+" matched: "+matched+" map size: "+ map.size());
            
            
            
            if(length == s1.length()){
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