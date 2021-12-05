class Solution {
    public int[] searchRange(int[] nums, int target) {
//         bst
// Input: nums = [5,7,7,8,8,10], target = 8
                        // ^
// Output: [3,4]
        // do the bswith first starting target
        // do the bs with last starting target
        
        
        int left= bs(nums, target, true);
        int right = bs(nums, target, false);

        if(left == -1) return new int[]{-1,-1};
        return new int[]{left,right};
    }
    public int bs(int[] nums, int target, boolean isFirst){
        int left = 0;
        int right = nums.length-1;
        
        while(left<=right){
            int mid = left+(right-left)/2;
            
            if(nums[mid] == target){
                if(isFirst){
                    if(mid == left || nums[mid-1] != target)
                        return mid;
                    right = mid-1;
                }else{
                    if(mid == right || nums[mid+1] !=target)
                        return mid;
                    left = mid+1;
                }
            }else if(nums[mid]> target){
                right = mid-1;   
            }else
                left = mid+1;
        }
        return -1;
    }

}