class Solution{
    public int expressiveWords(String s, String[] words) {
        int count = 0;
        for(String originalWord: words){
            if(isStretchy(originalWord, s)){
                count ++;
            }
        }
        return count;
    }

    private boolean isStretchy(String originalWord, String stretched){
        int i = 0, j = 0;
        while(i < originalWord.length() && j < stretched.length()){
			//Check Rule 1
            if(originalWord.charAt(i) != stretched.charAt(j)){
                return false;
            }
            
            int repeated1 = getRepeatedLength(originalWord, i);
            int repeated2 = getRepeatedLength(stretched, j);
            
            //Check Rule 2
            if((repeated1 >= repeated2 || repeated2 < 3) && repeated1 != repeated2){
                return false;
            }
            
            i += repeated1;
            j += repeated2;
        }
        
        //Check Rule 1
        return i == originalWord.length() && j == stretched.length();
    }
    
    private int getRepeatedLength(String word, int start){
        int end = start;
        while (end < word.length() && word.charAt(end) == word.charAt(start)){
            end ++;
        }
        
        return end - start;
    }
}