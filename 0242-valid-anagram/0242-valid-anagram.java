class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        Map<Character, Integer> sFreq = new HashMap<>();
        for(char c: s.toCharArray()){
            sFreq.put(c, sFreq.getOrDefault(c, 0)+1);
        }
        
        for(char c: t.toCharArray()){
            if(!sFreq.containsKey(c))
                return false;
            sFreq.put(c, sFreq.get(c)-1);
            if(sFreq.get(c) ==0)
                sFreq.remove(c);
        }
        return true;
    }
}