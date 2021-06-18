class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int returnIndex = -1;
        
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target){
                returnIndex = mid;
                return returnIndex;
            } 
            
            else if(nums[left]<=nums[mid]){
                if(nums[left] <=target && target< nums[mid]){  //in between in normal order
                    right = mid-1;
                    continue;
                }else{              //if(not in that range)
                    left= mid+1;
                    continue;
                }
            }else{
                if(target>=nums[left]|| target<nums[mid]){
                    right = mid-1;
                    continue;
                }else{
                    left = mid+1;
                    continue;
                }
            }
        }
        return returnIndex;
    }
}