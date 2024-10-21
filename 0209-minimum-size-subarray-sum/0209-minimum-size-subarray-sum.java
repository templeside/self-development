class Solution {
    /*
    sliding window is possible because it does not have the negative integers
    if it was not possible, we can go to prefixsum.
    
    increment: 
        update values.
        
    decrement: when currSum>= target
        if(currSUm == target)
            update minimum size sub array sum - minSub
        decrement -= endNum
        shift end
    */
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int currSum = 0;
        int endIdx = 0;
        int minSub = n+1;
        for(int startIdx=0; startIdx< n; startIdx++){
            // increment: 
            currSum += nums[startIdx];

            // update values.

            // decrement: when currSum>= target
            while(currSum >= target){            
                int windowSize = startIdx-endIdx+1;
                // update minimum size sub array sum - minSub
                minSub = Math.min(minSub, windowSize);
                
                int endNum = nums[endIdx];
                currSum -= endNum;
                endIdx++;
            }
        }
        return minSub == n+1? 0: minSub;
    }
}