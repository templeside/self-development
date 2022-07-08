class Solution {
    /**
    i need to check the anagram is based on the counting.
    using hashmap<character, count>, find all the valid counts.
    **/
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> map=  new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        for(char c: t.toCharArray()){
            if(! map.containsKey(c))return false;
            
            map.put(c, map.get(c)-1);
            if(map.get(c) ==0)
                map.remove(c);
        }
        
        return map.size()==0;
    }
}