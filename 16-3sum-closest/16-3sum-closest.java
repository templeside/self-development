class Solution {
    /**
    1. iterate all of the integers with 3 forloop, and get sum, compare with the target.
    for(int i=0; i< nums.length-2; i++){
        for(int j= i+1; j< nums.length-1; j++){
            for(int k = j+1; k< nums.length; k++){
                sum = nums[i]+nums[j]+nums[k];
                comparing with target, 
                    update the returnVal.
            }
        }
    } time complexity O(N^3) space: O(1)
    
    two pointer if the array is sorted.
    algorithm
    1. sort
    2. iterate through one for loop, and one two pointer algorithm.
        a.find pivot, sumTarget = target-pivot.
        left<right
        b.comprae with sum(left, right)
        c. compare with minDifference.
    
    Input: nums = [-4,-1,1,2], target = 1
    pivot              ^
    left                 ^
    right                  ^
    
    sumTarget = target- pivot = 2
    sum                         3
    minDifference = 2, 2
    Output: 1
    Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

    **/
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDifference = Integer.MAX_VALUE;
        int returningSum = 0;
        for(int pivotIdx = 0; pivotIdx< nums.length-2; pivotIdx++){
            int left=pivotIdx+1, right = nums.length-1;
            int sumTarget = target- nums[pivotIdx];
            
            while(left< right){
                int sum = nums[left]+ nums[right];
                if(Math.abs(target-(sum+nums[pivotIdx]))< minDifference){
                    minDifference = Math.abs(target-(sum+nums[pivotIdx]));
                    returningSum = sum + nums[pivotIdx];
                }
                
                if(sumTarget == sum){
                    return sum + nums[pivotIdx];
                }else if( sumTarget> sum){
                    left++;
                }else{
                    right --;
                }
            }
        }
        return returningSum;        
    }
}