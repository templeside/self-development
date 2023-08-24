class Solution {
    /*
    ransomeNote - a
    magazine - b
    
    a-1
    
    */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] frequency= new int[26];
        for(char c : magazine.toCharArray()){
            frequency[c-'a'] ++;
        }
        
        for(char c: ransomNote.toCharArray()){
            frequency[c-'a']--;
            System.out.println(frequency[c-'a']);
            if(frequency[c-'a']<0)
                return false;

        }
        return true;
    }
}