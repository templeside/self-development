class Solution {
    /**
    Input: ransomNote = "aa", magazine = "aab"
    Output: true
    
    counter of the magazine shoul always be bigger than ransomNote.
    **/
    public boolean canConstruct(String ransomNote, String magazine) {
        if(magazine.length()< ransomNote.length())return false;
        HashMap<Character, Integer> counter = new HashMap<>();
        
        for(char c: magazine.toCharArray()){
            counter.put(c, counter.getOrDefault(c, 0)+1);
        }
        
        for(char c: ransomNote.toCharArray()){
            counter.put(c, counter.getOrDefault(c,0)-1);
            if(counter.get(c)<0)return false;
        }
        
        return true;
    }
}