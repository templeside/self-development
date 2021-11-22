class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        
        for(int pivot =0; pivot<nums.length-2; pivot++){
            if(pivot ==0 || (pivot>0 && nums[pivot] != nums[pivot-1])){
                int left = pivot+1;
                int right = nums.length-1;
                int sum = 0-nums[pivot];

                while(left< right){
                    if(nums[left] + nums[right] ==sum){
                        ans.add(Arrays.asList(nums[pivot],nums[left],nums[right]));
                        while(left < right && nums[left] == nums[left +1]) left++;
                        while(left < right && nums[right] == nums[right-1]) right --;
                        left ++;
                        right --;
                    }else if( nums[left] + nums[right] >sum)
                        right--;
                    else
                        left ++;
                }
            }
        }
        return ans;
    }
}