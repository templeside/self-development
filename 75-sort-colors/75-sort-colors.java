class Solution {
/**
given array 'nums' three selection. sort in-place.

because we can sort the values by binary with two pointers, the middle can be another category, which means we can sort in three category too.

Input: nums = [0,0,2,1,1,2]
curr           ^
left           ^
right                  ^
**/
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] nums) {
        int curr=0, left =0, right=nums.length-1;
        
        while(curr<=right){
            int currNum = nums[curr];
            
            if(currNum == 0){
                swap(nums, left, curr);
                left ++;
                curr++;
            }else if(currNum == 2){
                swap(nums,curr, right);
                right --;
            }else
                curr++;
        }
    }
}