class Solution {
    /*
    always go brute force
    
    [1,2,3,4,100,200]
    longest = [1,2,3,4]
    
    if i have hashset, I can do same thing.
    
    i can just check all the longest values.
    Input: nums = [100,4,200,1,3,2]
                                 ^
                    
    1234 100 200 
    
    longest = 4
    
    // 1. add to hashset
    // 2. check left & right for consecutive length
    // 3. update longest
    */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longest = 0;
        // for each num
        for(int num: nums){
            // 1. add to hashset
            set.add(num);
        }
        
        for(int num: nums){
            // 2. check left & right for consecutive length
            int left = num;
            int right = num;
            while(set.contains(left-1)){
                left = left-1;
                set.remove(left);
            }
            while(set.contains(right+1)){
                right = right+1;
                set.remove(right);
            }
            
            // 3. update longest
            longest = Math.max(longest, right-left+1);
        }
        return longest;
    }
}