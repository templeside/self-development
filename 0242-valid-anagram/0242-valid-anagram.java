class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())return false;
        
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)-1);
            if(map.get(c) <0)return false;
            if(map.get(c) ==0)
                map.remove(c);
            
        }
        return map.size()==0;
    }
}