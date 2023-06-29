class Solution {
    /*
    nums = [1,2,3,4]
    left = [1,1,2,6]
    right= [24,12,4,1]
    
    I would have two array which is the product of left side & right side
    left = product(all the left side)
    right = product(all the right side)
    
    */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        left[0]=1;
        for(int i=1; i< n; i++){
            left[i] = left[i-1] * nums[i-1];
        }
        
        right[n-1] = 1;
        for(int i=n-2; i>=0; i--){
            right[i] = right[i+1]*nums[i+1];
        }
        
        for(int i=0; i< n; i++){
            nums[i] = left[i]*right[i];
        }
        return nums;
    }
}