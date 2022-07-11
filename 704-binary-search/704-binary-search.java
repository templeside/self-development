class Solution {
    /**
    finding can be done in iteration with time complexity of O(N).
    however, we can shrink out range by dividing by two if the array is sorted.
    
    **/
    public int search(int[] nums, int target) {
        int left=0,right = nums.length-1;
        
        while(left<=right){
            int mid = left+(right-left)/2;
            
            if(nums[mid] == target)return mid;
            else if(nums[mid]> target)
                right = mid-1;
            else
                left = mid+1;
        }
        return -1;
    }
}