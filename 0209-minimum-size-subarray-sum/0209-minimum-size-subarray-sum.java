class Solution {
    /*
    increment: 
        update sum
    
    decrement: when sum>= target
        update windowSize
        decrement sum
        shift windowTail
    */
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int min = nums.length+1;
        int windowStart=0;
        int windowTail = 0;
        
        for(; windowStart< nums.length; windowStart++){
            sum += nums[windowStart];
            
            while(sum>= target){
                min = Math.min(windowStart-windowTail+1, min);
                sum -= nums[windowTail];
                windowTail ++;
            }
        }
        
        return min ==nums.length+1? 0: min;
    }
}