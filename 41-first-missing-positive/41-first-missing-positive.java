class Solution {
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int firstMissingPositive(int[] nums) {
        int i=0;
        while( i< nums.length){
            int origIdx = nums[i]-1;
            if( nums[i]>0 && nums[i]<=nums.length && nums[i] != nums[nums[i]-1])
                swap(nums,i,nums[i]-1);
            else
                i++;
        }
        for(i=0; i< nums.length; i++){
            if(nums[i] != i+1)
                return i+1;
        }
        return nums.length+1;
    }
}