class Solution {
    
    /**
    Input: nums = [-1,0,1,2,-1,-4]
    pivot           ^
    left              ^
    right                       ^
    
    trying to find a sum = nums[pivot]+nums[left]+nums[right] == 0;
    
    ending
    pivot                 ^   
    left                     ^
    right                       ^
    Output: [[-1,-1,2],[-1,0,1]]
        
    in this case, I am going to use a pivot and two pointers.
    
    no duplicates - checker.
    how to find duplicates? 
        for two pointers, move to next pointer avoiding duplicates
        for pivot, move to next pointer 
    
    Time complexity: O(N^2) two for loop(pivot, twosum)
    */
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int pivot = 0; pivot< nums.length-2;pivot++){
            if(pivot ==0 || nums[pivot] != nums[pivot-1]){
                int left = pivot+1;
                int right = nums.length-1;
                
                while(left < right){
                    int sum = nums[pivot] + nums[left] + nums[right];
                    
                    if(sum == 0){
                        ans.add(List.of(nums[pivot], nums[left], nums[right]));
                        while(left<right &&nums[left] == nums[left+1])left++;
                        while(left< right &&nums[right] == nums[right-1]) right--;
                        left++;
                        right--;
                    }
                    else if(sum>0)right --;
                    else left++;
                }
            }
            
        }
        return ans;
    }
}