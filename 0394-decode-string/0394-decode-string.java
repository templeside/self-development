class Solution {
    /*
    they would want to have the problem solved.
    3[a]2[bc]
    
    starting form left, iterate over
        openIdx = findNext([, idx)
        closeIdx = findNext(], idx)
    
    if no openIdx,
        return current string
    digit = substring(currIdx, openIdx)
    str = s.substring(openIdx+1, closeIdx)
        
    */
    public String decodeString(String s) {
        int currIdx=0;
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        
        // starting form left, iterate over
        while(currIdx< n){
            char currChar = s.charAt(currIdx);
            if(Character.isDigit(currChar)){
                int openIdx = findOpen(currIdx, s);
                int closeIdx = findClose(openIdx, s);

                int digit = Integer.parseInt(s.substring(currIdx, openIdx));
                String str = decodeString(s.substring(openIdx+1, closeIdx));
                
                for(int i=0; i< digit; i++){
                    sb.append(str);
                }
                currIdx = closeIdx+1;
            }
            else{
                sb.append(currChar);
                currIdx++;
            }
        }
        return sb.toString();
    }
    public int findOpen(int currIdx, String s){
        for(int i=currIdx; i< s.length(); i++){
            if(s.charAt(i) =='[')
                return i;
        }
        return s.length();
    }
    public int findClose(int openIdx, String s) {
        int openCount = 1;
        for (int i = openIdx + 1; i < s.length(); i++) { // Ensure i doesn't exceed length
            if (s.charAt(i) == '[') {
                openCount++;
            } else if (s.charAt(i) == ']') { // Properly count closing brackets
                openCount--;
            }
            if (openCount == 0) { // When count balances, return the index
                return i;
            }
        }
        throw new IllegalArgumentException("No matching closing bracket found");
    }

}