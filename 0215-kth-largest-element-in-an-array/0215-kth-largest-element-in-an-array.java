class Solution {
    /*
    priorityqueue
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
    
max    3 2
    */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}