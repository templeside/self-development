class Solution {
    /*
    find first
    find last
    
    if found first,
    if found target,
        right = mid-1
        
        
    */
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int first = findFirst(0, n-1, nums, target);
        if(first == -1)
            return new int[]{-1,-1};
        
        int last = findLast(first, n-1, nums, target);
        return new int[] {first, last};
    }
    public int findFirst(int i, int j, int[] nums, int target){
        int first = -1;
        
        while(i<=j){
            int mid = i+(j-i)/2;
            if(nums[mid] == target){
                first = mid;
                j = mid-1;
            }else if(nums[mid]> target)
                j = mid-1;
            else
                i = mid+1;
        }
        return first;
    }
    public int findLast(int i, int j, int[] nums, int target){
        int last = -1;
        
        while(i<=j){
            int mid = i+(j-i)/2;
            if(nums[mid] == target){
                last = mid;
                i = mid+1;
            }else if(nums[mid]> target)
                j = mid-1;
            else
                i = mid+1;
        }
        return last;
    }
}