class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> returnVal = new ArrayList<>();
        int target = 0;
        int n = nums.length;
        for(int i=0; i<n-2; i++ ){
            if(i>0 &&nums[i] ==nums[i-1])continue;
            
            int left=  i+1;
            int right = n-1;
            while(left< right){
                int sum = nums[left]+ nums[right]+nums[i];
                if(sum == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    returnVal.add(temp);
                    
                    
                    
                    while(left<right &&nums[left] == nums[left+1]) left++;
                    while(left<right && nums[right] == nums[right-1]) right--;
                    
                    left ++;
                    right --;
                }else if(sum> 0){
                    // while(left<right && nums[right] == nums[right-1]) right--;
                    right --;
                }else{
                    // while(left<right &&nums[left] == nums[left+1]) left++;
                    left++;
                }
            }
        }
        return returnVal;
    }
}