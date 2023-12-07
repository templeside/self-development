class Solution {
    /*
    is this oddNumber
    sliding window - substring.
    increment as time goes
        52
start   ^
end     ^
    increment
    shrink
    */
    public String largestOddNumber(String num) {
        int n = num.length();
        for(int i=n-1; i>=0; i--){
            int currDigit = (num.charAt(i) - '0');
            if(currDigit%2 == 1){
                return num.substring(0, i+1);
            }
                
        }
        return "";
    }
}