class Solution {
    public int[] plusOne(int[] digits) {
        int n =digits.length;
        int offset= 1;
        
        for(int i=n-1; i>=0; i--){
            int currVal = digits[i]; 
            digits[i] = (currVal +offset)%10;
            offset = (currVal +offset)/10;
        }
        if(offset == 1){
            int[] returnVal = new int[n+1];
            for(int i=0; i<n; i++){
                returnVal[i+1] = digits[i];
            }
            returnVal[0] = 1;
            tostring(returnVal);
            return returnVal;
        }
        return digits;
    }
    public void tostring(int[] arr){
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i]);
        System.out.println();
    }
}