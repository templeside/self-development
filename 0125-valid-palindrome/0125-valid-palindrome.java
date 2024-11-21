class Solution {
    public boolean isPalindrome(String s) {
        int left =0, right = s.length()-1;
        s=s.toLowerCase();
        while(left< right){
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            
            if(!Character.isLetterOrDigit(leftChar)){
                left++;
                continue;
            }
            else if(!Character.isLetterOrDigit(rightChar)){
                right--;
                continue;
            }
            else if(leftChar != rightChar)
                return false;
            left++;
            right--;
        }
        return true;
    }
}