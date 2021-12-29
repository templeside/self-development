class Solution {
    public int findMin(int[] nums) {
         
        // arr = [3,4,5,1,2]
        // 1. when mid > right
            // left = mid+1
        // 2. when mid <= right
//             saved = mid. 
            // right = mid-1;
        int left = 0, right = nums.length-1;
        int saved = -1;
        
        while(left<= right){
            int mid = left+(right-left)/2;
            
            if(nums[mid]<=nums[nums.length-1]){
                saved = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return nums[saved];
        
        
    }
}

// 3, 1, 2
// left 3   3
// mid  1   3  
// right2   3
// saved2   1