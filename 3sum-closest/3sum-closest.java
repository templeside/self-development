class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0]+nums[1]+nums[2];
        
        for(int left = 0; left< nums.length; left++){
            int mid = left+1;
            int right = nums.length-1;
            
            while(mid<right){
                int sum = nums[left]+nums[right]+nums[mid];
                closest = Math.abs(target-sum)<Math.abs(target-closest)? sum: closest;
                
                if(target == sum)
                    return sum;
                else if( target> sum)
                    mid ++;
                else
                    right --;
            }
        }
        return closest;
    }
}