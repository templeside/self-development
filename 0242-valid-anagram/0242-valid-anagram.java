class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        int[] sFreq = new int[26];
        int n = s.length();
        
        for(int i=0; i<n; i++){
            int currSchar = s.charAt(i)-'a';
            sFreq[currSchar]++;
        }
        
        for(int i=0; i<n; i++){
            int currTchar = t.charAt(i)-'a';
            if(sFreq[currTchar] <=0)return false;
            sFreq[currTchar] --;
        }
        return true;
    }
}