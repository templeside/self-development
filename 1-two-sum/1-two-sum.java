class Solution {
    /**
    values are unique.
    only have exact one solution
    
    nums =[ 2,7,11,15]  target=9
              ^
    remainder = 9-7 = 2
    map = {2:0}
    
    return {map.getvalue(2), 0}
    **/
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0 ; i<nums.length; i++){
            int currVal = nums[i];
            int remainder = target-currVal;
            
            if(map.containsKey(remainder))
                return new int[]{map.get(remainder), i};
                
            map.put(currVal, i);
            
        }
        return null;
    }
}