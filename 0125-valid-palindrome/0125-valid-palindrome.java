class Solution {
    /*
    "race a car"
     ^        ^
     
    */
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left=0;
        int right =s.length()-1;
        
        while(left<right){
            if(!Character.isAlphabetic(s.charAt(left)) && !Character.isDigit(s.charAt(left))){
                left++;
                continue;
            }
            else if (!Character.isAlphabetic(s.charAt(right)) && !Character.isDigit(s.charAt(right))){
                right--;
                continue;
            }
            
            if(s.charAt(left)!= s.charAt(right))
                return false;
            
            left++;
            right--;
        }
        return true;
    }
}