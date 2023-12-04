class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxSum = -1;
        
        int left = 0;
        int right = n-1;
        while(left< right){
            int sum = nums[left]+ nums[right];
            if(sum < k){
                maxSum = Math.max(sum,maxSum);
                left++;
            }
            else{
                right --;
            }
        }
        return maxSum;
    }
}