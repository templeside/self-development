class Solution {
    public int minDifference(int[] nums) {
        
        if(nums.length<4)
            return 0;
        
        Arrays.sort(nums);

        int start =0;
        int last = nums.length-1;
        int min = Integer.MAX_VALUE;
        
        min = Math.min(min, nums[last] - nums[start+3] );
        min = Math.min(min, nums[last-1] - nums[start+2] );
        min = Math.min(min, nums[last-2] - nums[start+1] );
        min = Math.min(min, nums[last-3] - nums[start] );
        
        return min;
    }
}