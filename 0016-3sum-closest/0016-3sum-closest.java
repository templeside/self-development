class Solution {
    /*
    sort
    moving to similar version.
    target closer to the target
    
    [-4,-1,1,2]
i        ^
j          ^
k            ^
sum =       -3 -1 2
closest =   -3 -1 
target = 1
    */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0]+nums[1]+nums[2];
        
        for(int i=0; i< nums.length-2; i++){
            int j= i+1;
            int k = nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                closest = Math.abs(target- closest) > Math.abs(target-sum)? sum: closest;
                
                if(sum == target)
                    return sum;
                else if(sum< target)
                    j++;
                else
                    k--;
            }
        }
        return closest;
    }
}