class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // backtracking through all numbers.
        List<List<Integer>> returnVal = new ArrayList<>();
        //so, in the paramter, there should be currsum, target, currVal, returnVal
        // backtrack(0, currVal, currIdx, returnVal, target);
        backtrack(0, new ArrayList<>(), -1, returnVal, candidates, target);
        return returnVal;
    }
    public void backtrack(int currSum, List<Integer> currVal, int currIdx, List<List<Integer>> returnVal, int[] candidates, int target){
        //base case is if the currIdx == currVal.size() or reaches the target.
        if(currSum > target)
            return;
        
        // when successful
        if(currSum == target)
            returnVal.add(new ArrayList(currVal));
        
        for(int i= currIdx; i< candidates.length;i++){
            if(i == -1)continue;
            currSum += candidates[i];
            currVal.add(candidates[i]);
            backtrack(currSum, currVal, i, returnVal, candidates, target);
            
            currSum -= candidates[i];
            currVal.remove(currVal.size()-1);
        }
        
        
        //while backtracking, find the target, and if the sum is same, then add the item into the returnVal.
        
        
    }
}