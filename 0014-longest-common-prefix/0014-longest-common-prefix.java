class Solution {
    public String longestCommonPrefix(String[] strs) {
        int idx =0;
        
        for(; idx< strs[0].length(); idx++){
            char currChar = strs[0].charAt(idx);
            
            for(String str: strs){
                if(idx>= str.length() || str.charAt(idx) != currChar)
                    return str.substring(0,idx);
            }
        }
        return strs[0];
    }
}