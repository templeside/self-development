class Solution {
    /*
    1. find out the target
        if found,
            find first
            find last
            
[5,7,7,8,8,10]
 ^
            ^
       ^       
        if not found, return[-1,-1]
        
        for searching first,
            if found mid
                mostfront = mid
                right = mid-1
            
    */
    public int[] searchRange(int[] nums, int target) {
        //find target;
        int idx = findMid(nums, target);
        if(idx == -1)
            return new int[]{-1,-1};
        int left = findFront(nums, idx, target);
        int right = findEnd(nums, idx, target);
        
        return new int[]{left,right};
    }
    
    public int findMid(int[] nums, int target){
        int n = nums.length;
        int left= 0;
        int right = n-1;
        
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target)
                return mid;
            
            else if(nums[mid]< target){
                left = mid+1;
            }else
                right = mid-1;
        }
        return -1;
    }
    public int findFront(int[] nums, int right, int target){
        int n = nums.length;
        int left= 0;
        int returnVal = right;
        
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target || nums[mid]> target){
                right = mid-1;
                returnVal = mid;

            }else{
                left = mid+1;
            }
        }
        return returnVal;
    }
    public int findEnd(int[] nums, int left, int target){
        int n = nums.length;
        int right= n-1;
        int returnVal = left;
        
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target || nums[mid]< target){
                left = mid+1;
                returnVal = mid;

            }else{
                right = mid-1;
            }
        }
        return returnVal;
    }
}