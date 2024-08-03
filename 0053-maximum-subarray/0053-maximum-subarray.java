class Solution {
    /*
    max subarray면 curr이 내꺼보다 큰지 작은지 확인하면 된다
    다음 update maxSubArray하면 된다.
    원리: subarray이기 때문에 curr이 prev sum보다 큰지로 끊는다.
    
    [5,4,-1,7,8]
    
    */
    public int maxSubArray(int[] nums) {
        if(nums.length == 0)
            return 0;
        int currSum = nums[0];
        int maxSubArr = nums[0];
        for(int i=1; i< nums.length;i++){
            currSum = Math.max(currSum+nums[i], nums[i]);
            maxSubArr = Math.max(maxSubArr, currSum);
        }
        return maxSubArr;
    }
}