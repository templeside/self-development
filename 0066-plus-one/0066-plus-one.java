class Solution {
    //update from the last digit with offset.
    public int[] plusOne(int[] digits) {
        int offset = 1;
        int n = digits.length;
        
        for(int i= n-1; i>=0; i--){
            int sum = offset + digits[i];
            digits[i] = sum%10;
            offset = sum/10;
        }
        
        if(offset == 0)
            return digits;
        else{
            int[] newArr = new int[n+1];
            newArr[0] = 1;
            for(int i=0; i<n; i++){
                newArr[i+1] = digits[i];
            }
            return newArr;
        }
    }
}