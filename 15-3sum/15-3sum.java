class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        
        for(int pivot = 0; pivot< nums.length-2; pivot++){
            if(pivot ==0 || (pivot>0 && nums[pivot] != nums[pivot-1])){     //같지 않을 때.
                int left = pivot+1;
                int right = nums.length-1;
                int target = 0-nums[pivot];
                
                while(left<right){
                    int sum = nums[left] + nums[right];
                    if(sum == target){
                        ans.add(Arrays.asList(nums[pivot], nums[left], nums[right]));
                        while(left< right && nums[left] == nums[left +1])left ++;
                        while(left<right && nums[right] == nums[right -1]) right --;
                        left ++; 
                        right --;
                    }else if(sum> target) right --;
                    else left ++;
                    
                }
            }
        }
        return ans;
    }
}