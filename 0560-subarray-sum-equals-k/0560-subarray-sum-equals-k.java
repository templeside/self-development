class Solution {
    /*
    contiguous subarray.
    hard to do sliding window
    can't shift.
    i would use prefixsum to keep in track of valid sums.
    */
    public int subarraySum(int[] nums, int k) {
        int n= nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int currSum = 0;
        int count=0;
        for(int i=0; i<n ;i++){
            currSum += nums[i];
            
            int diff = currSum-k;
            if(map.containsKey(diff))
                count += map.get(diff);
            
            map.put(currSum, map.getOrDefault(currSum,0)+1);
        }
        return count;
    }
}