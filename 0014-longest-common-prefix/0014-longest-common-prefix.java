class Solution {
    /*
    by iteration, you can find out whats the problem
    
    if all seems same,
        increment prefix
    
    return prefix
    
["flower"
,"flow"
,"flight"]
i ^
j
currChar = f
    */
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb=  new StringBuilder();
        for(int i=0; i< strs[0].length(); i++){
            char currChar = strs[0].charAt(i);
            
            for(int j=1; j< strs.length; j++){
                // System.out.println(strs[j]);
                if(strs[j].length()<= i || strs[j].charAt(i) != currChar)
                    return sb.toString();
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }
}