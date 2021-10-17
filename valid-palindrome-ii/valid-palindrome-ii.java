class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        
        while(left <right){
            char l = s.charAt(left);
            char r = s.charAt(right);
            
            if(l != r){
                return isPalindrome(s,left,right-1) || isPalindrome(s,left+1, right);
            }
            left++;
            right--;
        }
        return true;
    }
    
    private boolean isPalindrome(String s, int left, int right){
        while(left<right){
            if(s.charAt(left++) != s.charAt(right--))
                return false;
        }
        return true;
    }
}