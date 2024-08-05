class Solution {
    /*
    only having on count to think of credit.
    in that credit:
        check left has shifted
        check right has shifted
    */
    public boolean validPalindrome(String s) {
        int left =0, right = s.length()-1;
        int credit = 1;
        
        while(left<right){
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            
            if(leftChar != rightChar){
                credit = 0;
                return isValidRecursion(left+1, right, s) || isValidRecursion(left, right-1, s);
            }
            left++;
            right--;
        }
        return true;
    }
    public boolean isValidRecursion(int left, int right, String s){
        while(left<right){
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            
            if(leftChar != rightChar){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}