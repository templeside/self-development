class Solution {
                        // <num value, indices>
    // 1. construct hashMap< Integer, List<Integer>>
    Map<Integer, List<Integer>> map;

    public Solution(int[] nums) {
        map = new HashMap<>();
        
        for(int i=0; i< nums.length;i++){
            List<Integer> tempList = map.getOrDefault(nums[i], new ArrayList<>() );
            tempList.add(i);
            map.put(nums[i], tempList);
        }
    }
    
    public int pick(int target) {
        if(!map.containsKey(target))return -1;
        
        List<Integer> indices = map.get(target);
        Random randVal = new Random();
        int idx = randVal.nextInt(indices.size());
        return indices.get(idx);
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */