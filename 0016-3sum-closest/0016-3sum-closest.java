class Solution {
    /*
    keep the sum minimum closest
    shift left or right to be closer to the target.
    
    should have three pointers.
    should be sorted because we are doing the index shifting.
    
    algorithm divide into two parts:
    1. for loop - deduct and find the remainder
    2. compare with remainder - update left or right index to shift.
        twonumSum == remainder, return target;
        compare with closestSum.
        twonumSum > remainder, right--;
        twonumSum < remainder, left++
    */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0]+nums[1]+nums[2];
        int n = nums.length;
        
        for(int i=0; i< n; i++){
            int left = i+1;
            int right = n-1;
            while(left< right){
                int sum = nums[i]+ nums[left]+ nums[right];
                
                closestSum = Math.abs(target-closestSum)> Math.abs(target-sum)?  sum: closestSum;
                if(sum> target){
                    right --;
                }else{
                    left++;
                }
            }
        }
        return closestSum;
    }
}