class Solution {
/**
how to step by??? swap all of the 
Input: nums = [1,2,3,4,5,6,7], k = 3
               0 1 2 3 4 5 6 
                 1
nums[i] = nums[i-1];
                          5 6
                 1 2 3 4 5 
                 i=1
                 
                 
nums[i] = nums[(i+1)%n]
nums[n-1]= temp;

Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

**/
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        int[] kShift = new int[k];
        for(int i=0; i<k;i++)
            kShift[i] =nums[nums.length-1-i];
        shiftRight(nums, kShift, k);
    }
    public void shiftRight(int[] nums, int[] kShift, int k){
        int n = nums.length, temp = nums[n-1];
        for(int i=n-1; i>=k; i--){
            nums[i] = nums[i-k];
        }
        
        for(int i=0; i<k; i++){
            nums[i] = kShift[k-1-i];
        }
        
    }    
}