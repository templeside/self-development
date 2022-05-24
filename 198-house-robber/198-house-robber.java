class Solution {
    public int rob(int[] nums) {
        if(nums.length ==0)return 0;
        else if(nums.length ==1)return nums[0];
        else if(nums.length ==2)return Math.max(nums[0],nums[1]);
        
        int[] memo = new int[nums.length];
        memo[0] = Math.max(nums[0],0);
        memo[1] = Math.max(memo[0],nums[1]);
        
        for(int i=2; i<memo.length;i++){
            memo[i] = Math.max(memo[i-1], memo[i-2]+nums[i]);
        }
        return memo[memo.length-1];
    }
}