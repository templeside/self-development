class Solution {
    /**
    start from the robbing. 
    
    nums = [1,2,3,1]
    output = 4 
    because i don't want to get the two adjacent files.
    how??? I would get the ways to get the most maximum values I could get.
    how??? 
    initializing the best max values 
    values[i] = Math.max(values[i-1], values[i-2]+ nums[i])
    values = []
    **/
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        else if(nums.length == 1)return nums[0];
        else if(nums.length == 2)return Math.max(nums[0], nums[1]);
        
        int[] amount = new int[nums.length];
        amount[0] = Math.max(nums[0],0);
        amount[1] = Math.max(amount[0], nums[1]);
        
        for(int i=2; i< nums.length; i++){
            amount[i] = Math.max(amount[i-1], amount[i-2]+nums[i]);
        }
        return amount[nums.length-1];
    }
}