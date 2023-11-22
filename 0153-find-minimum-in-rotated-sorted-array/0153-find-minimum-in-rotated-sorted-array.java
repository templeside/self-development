public class Solution {
    public int findMin(int[] nums) {
        int min = nums[0];
        
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (nums[right] < nums[mid])
                left = mid + 1;
            else if (mid > left && nums[mid - 1] < nums[mid])
                right = mid - 1;
            else {
                min = nums[mid];
                break;
            }
        }
        
        return min;
    
    }
}
