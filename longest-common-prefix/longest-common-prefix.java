class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        int minLength = strs[0].length();
        
        for(String str: strs)
            minLength = Math.min(minLength, str.length());
        
        for(int i=0; i<minLength;i++){
            char c = strs[0].charAt(i);
            for(String str: strs){
                if(str.charAt(i) !=c)
                    return res;
            }
            res += c;
        }
        return res;
    }
}