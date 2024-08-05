class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wIdx=0;
        int aIdx=0;
        int aDigit=0;
        
        while(wIdx <word.length() && aIdx< abbr.length()){
            // char aChar = abbr.charAt(aIdx);
            while(aIdx<abbr.length() && Character.isDigit(abbr.charAt(aIdx))){
                if(aDigit == 0 &&abbr.charAt(aIdx)=='0')
                    return false;
                aDigit = aDigit*10 + (int)(abbr.charAt(aIdx)-'0');
                aIdx++;
            }

            if(aDigit>0){ 
                while(aDigit>0){
                    aDigit--;
                    wIdx++;
                }
            }else{
                if(word.charAt(wIdx)!=abbr.charAt(aIdx)){
                    return false;
                }
                wIdx++;
                aIdx++;
            }
        }
        return wIdx == word.length() && aIdx == abbr.length() && aDigit==0;
    }
}