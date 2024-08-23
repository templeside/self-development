class Solution {
    /*
    find the rotated place
    find the target in the range
        456123
         fttt 
        nums[i] <nums[i+1] true
        if mid == true
            assign right = mid-1
        if mid != true
            assing left =mid+1
            
    then find the target in two sub values
    */
    public int search(int[] nums, int target) {
        //find changing index
        int idx = findChangingIdx(nums);
        if(nums[0] <= target && target<=nums[idx])
            return findTarget(0, idx, nums, target);
        else
            return findTarget(idx+1,nums.length-1, nums, target);
    }
    
    public int findChangingIdx(int[] nums){
        int left=0; 
        int right=  nums.length-2;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]> nums[mid+1])
                return mid;
            else if(nums[left] <= nums[mid])
                left= mid+1;
            else
                right = mid-1;
        }
        return 0;
    }
    public int findTarget(int left, int right, int[] nums, int target){
        
        while(left<=right){
            System.out.println(left +" "+ right);
            int mid = left+(right-left)/2;
            if (nums[mid] ==target)
                return mid;
            else if(nums[mid]> target){
                right = mid-1;
            }else
                left = mid+1;
        }
        return -1;
    }
}