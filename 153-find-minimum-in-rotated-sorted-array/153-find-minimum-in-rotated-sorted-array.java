class Solution {
/**
               0 1 2 3 4
Input: nums = [3,4,5,1,2]
left                 ^
right              ^
mid                  ^
smallest = 1

in half, compare wit the mid. 

comparing with the most smallest number. shrink the range.

Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.

**/
    public int findMin(int[] nums) {
        int left = 0, right =  nums.length-1;
        int min = nums[nums.length-1];
        
        while(left<=right){
            int mid = left+(right-left)/2;
            
            if(nums[mid] <= min){
                min = nums[mid];
                right = mid-1;
            }
            else
                left = mid+1;
        }
        return min;
    }
}