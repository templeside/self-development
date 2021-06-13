class Solution {
    public int[] twoSum(int[] nums, int target) {
        // <number, index>
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i< nums.length;i++){
            map.put(nums[i],i);
        }
        
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            int offset = target-num;
            if(map.containsKey(offset) && map.get(offset) !=i)
                return new int[]{i,map.get(offset)};
        }
        return null;
    }
}
