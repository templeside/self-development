class Solution {
    /*
    "32 "-> 32
Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
Return the integer as the final result.

    */
    
    public int myAtoi(String s) {
        int integer = 0;
        int sIdx = 0;
        int sign = 1;
        
        //Read in and ignore any leading whitespace.
        while(sIdx< s.length() && s.charAt(sIdx)== ' ')
            sIdx++;
        
        if(sIdx == s.length())
            return 0;
        
        //check sign - or +
        if(s.charAt(sIdx) == '+')
            sIdx ++;
        else if(s.charAt(sIdx) =='-'){
            sIdx++;
            sign = -1;
        }
        
        while(sIdx< s.length()){
            int digit = s.charAt(sIdx)-'0';
            if(digit>9 || digit<0)break;
                
            
            if(Integer.MAX_VALUE /10 < integer || (Integer.MAX_VALUE/10 == integer && Integer.MAX_VALUE %10 < digit))
                return sign==1? Integer.MAX_VALUE: Integer.MIN_VALUE;
            
            integer = 10*integer + digit;
            sIdx++;
        }
            
        
        return integer * sign;
    }
}