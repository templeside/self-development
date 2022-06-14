class Solution {
    /**
    index and value should be same.
    nums = [3,0,1]
    idx     0 1 2
    sorted=[0,1,3]
    
    the idx 2 != 3, so the value should return 2.
    if the sorted is perfact match with nums, that means the n is not able to match, so return the number n.
    nums[i] == nums[nums[i]];
    */
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int missingNumber(int[] nums) {
        int i=0; 
        while(i<nums.length){
            if(nums[i]< nums.length && nums[i] != nums[nums[i]]){
                swap(nums, i, nums[i]);
            }else
                i++;
        }
        
        for(i=0; i< nums.length; i++){
            if(i!=nums[i]) return i;
        }
        return nums.length;
    }
}