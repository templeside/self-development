class Solution {
    /*
    arrays.sort
    dp
    [100,4,200,1,3,2]
    1 2 3 4 100 200
    ^
    1,1 
    */
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> dp = new HashMap<>();
        int n = nums.length;
        int longest =0;
        
        for(int i=0; i<n; i++){
            int curr = nums[i];
            dp.put(curr, dp.getOrDefault(curr-1, 0)+1);
            
            longest = Math.max(longest, dp.get(curr));
        }
        return longest;
    }
}