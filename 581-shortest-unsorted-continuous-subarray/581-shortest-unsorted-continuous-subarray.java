class Solution {
    /**
Input: nums = [2,6,4,8,10,9,15]
left             ^
right                   ^
[2,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

        [2,1]
left     ^
right      ^
max 
min

    **/
    public int findUnsortedSubarray(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left< nums.length-1 && nums[left] <= nums[left+1])
            left++;
        if(left == nums.length -1) return 0;
        
        while(right>0 && nums[right-1] <= nums[right])
            right--;
        
        int max = nums[left];
        int min = nums[left];
        for(int i=left; i<= right; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        
        while(left>0 && min< nums[left-1])
            left--;
        while(right<nums.length-1 && max> nums[right+1])
            right++;
        
        return right-left+1;
    }
}