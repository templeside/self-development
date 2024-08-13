class Solution {
    /*
    left+left+nums[i] == totalsum
    */
    public int pivotIndex(int[] nums) {
        int totalSum =  0;
        int leftSum = 0;
        int n = nums.length;
        for(int i=0; i<n;i++){
            totalSum += nums[i];
        }
        for(int i=0; i<n; i++){
            if(leftSum == totalSum - leftSum-nums[i])
                return i;
            leftSum += nums[i];
        }
        return -1;
    }
}