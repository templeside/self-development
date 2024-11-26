class Solution {
    /*
    those are anagram, so i would do implementation.
    check all the frequencies.
    go over and check comparison.
    
    freq
    freq.add
    
    if freq.char == 0
        remove the key
    if not in key
        return false;
    */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())return false;
        
        Map<Character, Integer> freq= new HashMap<>();
        for(char sChar: s.toCharArray()){
            freq.put(sChar, freq.getOrDefault(sChar,0)+1);
        }
        
        for(char tChar: t.toCharArray()){
            if(!freq.containsKey(tChar))
                return false;
            freq.put(tChar, freq.get(tChar)-1);
            if(freq.get(tChar)== 0)
                freq.remove(tChar);
        }
        return true;
    }
}