class Solution {
    public int removeElement(int[] nums, int val) {
        int slow =0, fast =0;
        for(; fast< nums.length;fast++){
            if(nums[fast]!=val){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}