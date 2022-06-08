class Solution {
    public int removeDuplicates(int[] nums) {
        int next = 1;
        for(int i=0; i< nums.length;i++){
            if(nums[i] != nums[next-1]){
                nums[next] = nums[i];
                next++;
            }
                
        }
        return next;
    }
}