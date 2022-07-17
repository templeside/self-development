class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> returnVal = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();
        int currIdx =0;
        
        backtrack(currIdx, currPath, returnVal, nums);
        return returnVal;
    }
    
    public void backtrack(int currIdx,List<Integer> currPath,List<List<Integer>> returnVal,int[] nums){
        returnVal.add(new ArrayList<>(currPath));
        
        for(int i=currIdx; i<nums.length; i++){
            if(i>currIdx && nums[i]==nums[i-1])continue;    //복사 멈춰!
            currPath.add(nums[i]);
            backtrack(i+1, currPath, returnVal, nums);
            currPath.remove(currPath.size()-1);
        }
    }
}