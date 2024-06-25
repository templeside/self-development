class Solution {
    /*
    starting from back, count the # 
    if count # >0:
        skip
    else
        add to the string.
    compare afterwards
    */
    public boolean backspaceCompare(String s, String t) {
        return returnString(s).equals(returnString(t));
    }
    
    public String returnString(String s){
        StringBuilder sb = new StringBuilder();
        int backCount = 0;
        
        for(int i=s.length()-1; i>=0; i--){
            System.out.println(sb.toString());
            char currChar = s.charAt(i);
            if(currChar =='#'){
                backCount ++;
                continue;
            }
                
            if(backCount >0){
                backCount--;
                continue;
            }
            
            sb.append(currChar);
        }
        return sb.reverse().toString();
    }
}