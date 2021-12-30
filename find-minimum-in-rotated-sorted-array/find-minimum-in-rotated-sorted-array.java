class Solution {
    public int findMin(int[] nums) {
        int left = 0, right =nums.length-1;
        int saved = -1;
        
        while(left<=right){
            int mid = left+(right-left)/2;
            
            if(nums[mid] <= nums[nums.length-1]){
                saved = mid;
                right = mid-1;
            }else
                left = mid+1;
        }
        return nums[saved];
    }
}