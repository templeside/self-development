class Solution {
    /*
    should be contiguous string.
    so we can use sliding window for efficient algorithm
    
    increment - windowStart
        update frequency
    decrement - when window size == s1.length() 
        update frequency matched or not
        decrement
        update matcehd
    */
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        int windowStart=0;
        int windowTail = 0;
        int matched = 0;
        
        for(char c: s1.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        for(; windowStart< s2.length(); windowStart++){
            char curr = s2.charAt(windowStart);
            if(map.containsKey(curr)){
                map.put(curr, map.getOrDefault(curr, 0)-1);
                if(map.get(curr)== 0)
                matched ++;
            }

            
            while(windowStart- windowTail+1 >= s1.length()){
                if(matched == map.size())
                    return true;

                char tailCurr = s2.charAt(windowTail);
                if(map.containsKey(tailCurr)){
                    if(map.get(tailCurr)==0)
                        matched --;
                    map.put(tailCurr, map.get(tailCurr)+1);
                }
                windowTail ++;
            }
        }
        return false;
    }
}