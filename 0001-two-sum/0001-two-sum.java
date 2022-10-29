class Solution {
    public int[] twoSum(int[] nums, int target) {
        // val, idx becuzz i need to return the indexof the values
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        
        for(int i=0; i< n; i++){
            int remainder = target-nums[i];
            if(map.containsKey(remainder)){
                return new int[]{i, map.get(remainder)};
            }
            
            map.put(nums[i], i);
        }
        return null;
    }
}