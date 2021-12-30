class Solution {
    public int find_rotation(int[] nums){
        int left = 0, right = nums.length-1;
        int saved = -1;
        
        while(left<=right){
            int mid = left+(right-left)/2;
            
            if(nums[mid]<= nums[nums.length-1]){
                saved = mid;
                right = mid-1;
            }
            else
                left = mid+1;
        }        
        return saved;
    }
    
    public int search(int[] nums, int target) {
        int smallest_idx = find_rotation(nums);
        
        if(smallest_idx ==0) return search(nums, 0,nums.length-1,target);
        else if(nums[smallest_idx]<= target && target<=nums[nums.length-1]) return search(nums, smallest_idx,nums.length-1,target);
        else return search(nums, 0, smallest_idx-1,target);
    }
    public int search(int[] nums, int left, int right,int target){
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid]>target)
                right =mid-1;
            else
                left = mid+1;


        }
        return -1;
    }
}