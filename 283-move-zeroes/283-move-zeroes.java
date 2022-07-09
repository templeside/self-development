class Solution {
    /**    
swap with the valid values.

Input: nums = [0,1,0,3,12]
               ^
Output: [1,3,12,0,0]

    **/
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void moveZeroes(int[] nums) {
        int validIdx = 0;
        for(int i=0; i<nums.length;i++){
            if(nums[i] !=0){
                swap(nums, i, validIdx);
                validIdx++;
            }
        }
    }
}