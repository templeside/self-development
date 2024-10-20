class Solution {
    /*
    consecutive - nums[i]< nums[i+1]
    lazy.
    so if it smaller than 0, sotp and move on.
    
    saving all the variables in to hashset and check is it having the next incrementing values.
    */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums)
            set.add(num);
        
        
        int longest = 0;
        for(int num : nums){
            longest = Math.max(longest, findLongest(set, num));
        }
        return longest;
    }
    public int findLongest(Set<Integer> set, int num){
        int count = 1;
        int left =num;
        int right =num;
        
        while(set.contains(left-1)){
            left--;
            count++;
            set.remove(left);
        }
        while(set.contains(right+1)){
            right++;
            count++;
            set.remove(right);
        }
        
        return count;
    }
}