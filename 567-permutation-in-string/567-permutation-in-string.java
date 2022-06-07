class Solution {
    /**
    three stages:
    1. contains s1, but not permutation -  shrink
    2. contains s1, permutation      return true.
    3. not contains s1     
    **/
    public boolean checkInclusion(String s1, String s2) {
        int windowStart =0;
        HashMap<Character, Integer> charCounter = new HashMap<>();
        int matched = 0;
        
        for(char c: s1.toCharArray()){
            charCounter.put(c, charCounter.getOrDefault(c, 0)+1);
        }
        
        for(int windowEnd = 0; windowEnd<s2.length(); windowEnd++){
            char endChar = s2.charAt(windowEnd);
            if(charCounter.containsKey(endChar)){
                charCounter.put(endChar, charCounter.getOrDefault(endChar,0)-1 );
                if(charCounter.get(endChar) ==0)
                    matched ++;
            }
            
            
            if(s1.length()< windowEnd-windowStart+1){
                char startChar = s2.charAt(windowStart);
                
                if(charCounter.containsKey(startChar)){
                    if(charCounter.get(startChar) ==0)
                        matched --;
                    charCounter.put(startChar,charCounter.getOrDefault(startChar,0)+1 );
                }
                windowStart++;
            }
            // System.out.println(charCounter);
            if(matched == charCounter.size())return true;
        }
        return false;
    }
}