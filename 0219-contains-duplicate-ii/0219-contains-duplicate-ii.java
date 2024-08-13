class Solution {
    /*
    nums[i] == nums[j]
    
    i-j<=k
    
    for loop:
        save hashmap
        where abs(i-j) <=k
    */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // <num, Index>
        Map<Integer, Integer> map = new HashMap<>(); 
        
        for(int i=0; i< nums.length; i++){
            int num = nums[i];
            if(map.containsKey(num) && Math.abs(i- map.get(num))<=k)
                return true;
            map.put(num, i);
        }
        return false;
    }
}