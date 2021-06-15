class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        HashSet<String> dict = new HashSet<String>();
        boolean[] isValid = new boolean[len+1];
        isValid[0] = true;
        
        for(String word: wordDict){
            dict.add(word);
        }
        
        for(int i=1;i<=len;i++){
            for(int j=0;j<i;j++){
                if(isValid[j] && dict.contains(s.substring(j,i))){
                    isValid[i] = true;
                }
            }
        }
        return isValid[len];
    }
}