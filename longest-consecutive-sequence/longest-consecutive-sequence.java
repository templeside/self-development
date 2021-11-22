// 1. add to hashmap< nums[i], visited or not>
// 2. do iteration for checking the value
// for iteration(hashamp.keySet()) if not valid:
//      update new count
//      iteration.
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length ==0)return 0;
        int maxCount=0;
        Set<Integer> set= new HashSet<>();
        
        for(int i: nums){
            set.add(i);
        }
        
        for(int i: nums){
            maxCount = Math.max(maxCount, find(i, set));
        }
        return maxCount;
    }
    
    public int find(int i, Set<Integer> set){
        if(!set.contains(i))
            return 0;
        int count = 1;
        set.remove(i);
        count += find(i+1, set);
        count += find(i-1, set);
        return count;
    }
}