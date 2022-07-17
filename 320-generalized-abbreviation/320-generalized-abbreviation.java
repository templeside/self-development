class Solution {
    /**
    backtrack condition:
        abbreviated
        not abbreviated.
        
        
            w           |1
            wo|w1       |1o     |2
       wor|1or|w1o|w2   |1or|1o1|2r|3
word|wor1 |...
   
    basecase- when reaches to the end of the index.
    
    currabbrev & currString
    currabbrev - count of abbreviation by.
    currString - representation of the return string.
    
    backtrack( currentabbrev+1, currstring)
    backtrack( currentabbrev, currstring+1)
    
    if currentabbrev >0, then do something.
    if currentabbrev <0 not in, do something.
    **/
    public List<String> generateAbbreviations(String word) {
        int currIdx = 0;
        int currAbbrev = 0;
        String currString="";
        List<String> returnVal = new ArrayList<>();
        
        backtrack(currIdx, currAbbrev, currString, word, returnVal);
        return returnVal;
    }
    
    public void backtrack(int currIdx, int currAbbrev, String currString, String word, List<String> returnVal){
        if(currIdx == word.length()){
            if(currAbbrev >0){
                currString += Integer.toString(currAbbrev);
            }
            returnVal.add(currString);
            return;
        }
        
        //do without abbreviation
        if(currAbbrev>0){
            String newString = currString + Integer.toString(currAbbrev)+word.charAt(currIdx);
            int newAbbrev=0;
            backtrack(currIdx+1, newAbbrev, newString, word, returnVal);
        }else{
            backtrack(currIdx+1, currAbbrev, currString+word.charAt(currIdx), word, returnVal);
        }
        
        //with abbreviation
        backtrack(currIdx+1, currAbbrev+1, currString, word, returnVal);
    }
}