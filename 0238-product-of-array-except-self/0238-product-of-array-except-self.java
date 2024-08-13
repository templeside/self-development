class Solution {
    /*
    two prefix sum
    leftPrefix
    rightPrefix
    
    */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftPrefix = new int[n];
        int[] rightPrefix = new int[n];
        
        leftPrefix[0] = nums[0];
        rightPrefix[n-1] = nums[n-1];
        for(int i=1; i<n; i++){
            leftPrefix[i] = leftPrefix[i-1] * nums[i];
            rightPrefix[n-1-i] = rightPrefix[n-i] * nums[n-1-i];
        }
        
        for(int i: leftPrefix){
            System.out.print(" "+i);
        }
        System.out.println();
        for(int i: rightPrefix){
            System.out.print(" "+i);
        }
        
        int[] returnVal = new int[n];
        
        returnVal[0]=rightPrefix[1];
        returnVal[n-1] = leftPrefix[n-2];
        for(int i=1; i<n-1; i++){
            int left = leftPrefix[i-1];
            int right = rightPrefix[i+1];
            returnVal[i] = left*right;
        }
        return returnVal;
    }
}