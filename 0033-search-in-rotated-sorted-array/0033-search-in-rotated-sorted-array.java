class Solution {
    /*
    find the starting point
    
    binary search - 
        if(nums[i] > nums[i+1])
        
    checking the left, middle
    if(nums[left] < nums[mid]) - sorted
        left = mid+1;
    else
        right = mid-1;
        
    search the range
    */
    public int search(int[] nums, int target) {
        if(nums.length == 1)
            return nums[0] == target? 0: -1;
        int endIdx= findEnd(nums);
        
        if(nums[0] <= target && target<= nums[endIdx]){
            return search(0, endIdx, nums, target);
        }
        return search(endIdx+1, nums.length-1, nums, target);
    }
    
    public int findEnd(int[] nums){
        int left=0;
        int right =nums.length-2;
        
        while(left<= right){
            int mid = left+(right-left)/2;
            
            if(nums[mid]> nums[mid+1])
                return mid;
            else if(nums[left] <= nums[mid])
                left = mid+1;
            else
                right = mid-1;
        }
        return nums.length-1;
    }
    public int search(int left, int right, int[] nums, int target){
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid]> target){
                right = mid-1;
            }else
                left = mid+1;
        }
        return -1;
    }
}