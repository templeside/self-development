class Solution {
    /**
               0 1 2 3 4 5 6
Input: nums = [4,5,6,7,0,1,2], target = 0
left                   ^
right                      ^
mid                      ^

comparing mid and target.
left< target < mid

mid < target < right 

        [3,1] target = 1
left     ^
right      ^
mid      ^
    
Output: 4

    **/
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        
        while(left<=right){
            int mid = left+(right-left)/2;
            
            if(nums[mid] == target)return mid;  
            else if(nums[left]<=nums[mid]){     //if left array is sorted,  -
                if(nums[left]<=target&& target <nums[mid] ){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{
                if(nums[mid]< target && target<= nums[right]){
                    left = mid+1;
                }else{
                    right= mid-1;
                }
            }
        }
        return -1;
    }
}