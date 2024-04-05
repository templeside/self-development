class Solution {
    /*
    to lower case, remove all non-alphanumeric characters
    
    forward and backward is same.
    
    two pointers left, right
    if(left & right is characters)
        check it is same
        
    "race a car"
        ^ ^
    */
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;
        
        while(left< right){
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if(!Character.isAlphabetic(leftChar) && !Character.isDigit(leftChar) ){
                left++;
                continue;
            }
            else if(!Character.isAlphabetic(rightChar) && !Character.isDigit(rightChar)){
                right--;
                continue;
            }
            else{
                leftChar = Character.toLowerCase(leftChar);
                rightChar = Character.toLowerCase(rightChar);
                if(leftChar != rightChar)
                    return false;
                
                left++;
                right--;
            }
        }
        return true;
    }
}