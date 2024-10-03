class Solution {
    public String mergeAlternately(String word1, String word2) {
        int w1Idx=0;
        int w2Idx=0;
        StringBuilder sb = new StringBuilder();
        
        while(w1Idx<word1.length() || w2Idx< word2.length()){
            if(w1Idx<word1.length()){
                sb.append(word1.charAt(w1Idx));
                w1Idx++;
            }
            if(w2Idx< word2.length()){
                sb.append(word2.charAt(w2Idx));
                w2Idx++;
            }
        }
        return sb.toString();
    }
}