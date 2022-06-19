class Solution {
    /**
Input: nums = [1,2,3]
                   ^
[[],[1],[1,2], [1,2,3],[1,3],[2],[2,3],[3]]

Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    
    
    **/
    public List<List<Integer>> subsets(int[] nums) {
        int currIdx = -1;
        List<Integer> currSubset = new ArrayList<>();
        List<List<Integer>> returnVal = new ArrayList<>();
        backtrack(currIdx, currSubset, nums, returnVal);
        
        return returnVal;
    }
    
    public void backtrack(int currIdx, List<Integer> currSubset, int[] nums, List<List<Integer>> returnVal){
        if(currIdx == nums.length) return;
        
        returnVal.add(new LinkedList<>(currSubset));
        for(int i=currIdx+1; i<nums.length; i++){
            currSubset.add(nums[i]);
            backtrack(i, currSubset, nums, returnVal);
            currSubset.remove(currSubset.size()-1);
        }
        return;
    }
}