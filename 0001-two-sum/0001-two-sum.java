class Solution {
    /*
    find difference.
    having hashset can find the offset.
    if we alreay found before, we can return the current num with visited num.
    
    set<Integer> visited
    */
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        if(n<2)
            return null;
        Map<Integer,Integer> visited = new HashMap<>();
        
        for(int i=0; i<n; i++){
            int num = nums[i];
            int offset = target - num;
            if(visited.containsKey(offset)){
                return new int[]{visited.get(offset), i};
            }
            
            visited.put(num, i);
        }
        return null;
    }
}