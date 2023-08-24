class Solution {
    /*
    would have the class that defines the array. 
    
    Str{
        String string
        int idx
        next(){
            if not, return 'X'
        }
    }
    
    for Str[],
        check current values.
    */
    public String longestCommonPrefix(String[] strs) {
        if(strs.length ==0)return "";
        int shortest = strs[0].length();
        for(String str: strs){
            shortest = Math.min(shortest, str.length());
        }
        
        int i = 0;
        
        for(i=0; i<shortest; i++){
            int currChar = strs[0].charAt(i);
            for(String str: strs){
                if(currChar != str.charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0].substring(0,i);
    }
}