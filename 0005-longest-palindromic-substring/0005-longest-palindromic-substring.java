class Solution {
    /*
    bottom up approach, find out the valueable palindrome.
    
    odd palindromes
    
    even palindromes
    
    recursion(left, right, string)
    edge case - out of index, or met the non palidromic values
    
    if(valid palindrome)
        recursion  (left-1, right -1, string)
    return maxString
    */
    public String longestPalindrome(String s) {
        if(s.length() == 0)return "";
        
        String longest = "";
        String temp="";
        for(int i=0; i<s.length(); i++){
            if(i != s.length()-1){
                temp = findLongest(i, i+1, s);
                longest = longest.length()> temp.length()? longest: temp;
            }
            
            temp = findLongest(i, i, s);
            longest = longest.length()> temp.length()? longest: temp;
        }
        return  longest;
    }
    
    public static String findLongest(int i, int j, String s){
        if(i<0 || j>= s.length())
            return "";
        
        if(s.charAt(i) != s.charAt(j))
            return "";
        
        
        String deeper = findLongest(i-1, j+1, s);

        if(deeper.equals(""))
            return s.substring(i, j+1);
        return deeper;        
    }
}