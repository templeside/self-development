class Solution {
    /*
    two options
    including
    non including
    starting from idx 0 -> n
    */
    public List<List<Integer>> subsets(int[] nums) {
        int start =0;
        List<Integer> currSet = new ArrayList<>();
        List<List<Integer>> returnVal = new ArrayList<>();
        backtrack(start, currSet, returnVal, nums);
        return returnVal;
    }
    public void backtrack(int idx, List<Integer> currSet, List<List<Integer>> returnVal, int[] nums){
        if(idx == nums.length){
            returnVal.add(new ArrayList(currSet));
            return;
        }
        
        backtrack(idx+1, currSet, returnVal, nums);
        
        currSet.add(nums[idx]);
        backtrack(idx+1, currSet, returnVal, nums);
        currSet.remove(currSet.size()-1);
    }
}