class Solution {
    /*
    nums[i]> nums[i+1]
    [1,2,3,1]
    */
    public int findPeakElement(int[] nums) {
        int peak = nums.length-1;
        int left=0;
        int right = nums.length-2;
        
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid] > nums[mid+1]){
                peak = mid;
                right= mid-1;
            }else
                left=mid+1;
        }
        return peak;
    }
}