class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0)return 0;
        else if(nums.length ==1)return nums[0];
        
        int max1 = rob_simple(nums, 0, nums.length -2);
        int max2 = rob_simple(nums, 1, nums.length -1);
        
        return Math.max(max1, max2);
    }
    
    public int rob_simple(int[] nums, int start, int end){
        if(end-start ==0)return nums[start];
        if(end-start == 1)return Math.max(nums[start], nums[end]);
        
        int[] memo = new int[nums.length];
        memo[start] = nums[start];
        memo[start+1] = Math.max(nums[start], nums[start+1]);
        
        for(int i= start+2; i<=end; i++){
            memo[i] = Math.max(memo[i-1], memo[i-2]+nums[i]);
        }
        
        return memo[end];
    }
}