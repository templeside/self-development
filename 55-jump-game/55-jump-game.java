class Solution {
    /*
    brute force is to reach out to the max jump I could get.
    how?? 
    from beginning, using two pointer to check where is the way to go further.
    
    trying to remove the overlap.
    
    trying to get the current index step by step.
    bottom up approach
    nums= [2,3,1,1,4]
    idx    ^
    maxIdx=    ^
    dp=   [f,f,f,f,f]
    update which one is larger, == n-1
    */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxIdx = 0;
        
        for(int i=0; i<n-1 && i<=maxIdx ; i++){
            maxIdx = Math.max(maxIdx, i+ nums[i]);
        }
        return maxIdx >= n-1;
    }
}