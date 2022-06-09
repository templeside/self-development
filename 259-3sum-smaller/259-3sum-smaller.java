class Solution {
/**
for my first intuition, I thought I can do the nums by iterating one index, and with that index, using two pointers, matching with the target complemented by the first index.


Input: nums = [-2,0,1,3], target = 2
sorted = [-2,0,1,3] target = 2
i          ^

currTarget =  4
            [0,1,3]
j            ^
k                ^
currSum = 0+3 < 4 smaller.

currTarget =  2-0 =0
            [1,3]
j            ^
k              ^
currSum = 4 == 4 not smaller.

[-2,0,1]
[-2,0,3]
Output: 2

**/
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count =0;
        for(int i=0; i<=nums.length-3; i++){
            count += findCount(i+1,nums.length-1, nums, target-nums[i] );
        }
        return count;
    }
    
    public int findCount(int j, int k, int[] nums, int target){
        int count =0;
        while(j<k){
            int sum = nums[j] + nums[k] ;
            if(sum< target){
                count += k-j;
                j++;
            }else
                k--;
        }
        return count;
    }
}