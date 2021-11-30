class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] mydict = new int[26];
        for(int i=0; i<order.length(); i++){
            int alpha = order.charAt(i)-'a';
            mydict[alpha]=i; // key = alphabet in number, value=index
        }
        
        // iterate through words in words[]
        for(int i=0; i<words.length-1; i++){ // we have to look at both i, i+1
            String word1 = words[i];
            String word2 = words[i+1];
            
            for(int j=0; j<word1.length(); j++){// iterate each alphabet
                if(j>=word2.length()) return false;
                
                if(word1.charAt(j)!= word2.charAt(j)){
                    if(mydict[word1.charAt(j)-'a'] > mydict[word2.charAt(j)-'a']){
                        return false;
                        // not in mydict order
                    }
                    else break;
                }
            }
            
            
        }
        // iterate through their character
        
        return true;
        
    }
}