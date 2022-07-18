class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> returnVal = new ArrayList<>();
        List<Integer> currPath= new ArrayList<>();
        int currIdx =0;
        backtrack(currIdx, currPath, returnVal, target, candidates);
        
        return returnVal;
    }
    
    public void backtrack(int currIdx, List<Integer> currPath, List<List<Integer>> returnVal, int target, int[] candidates){
        if(target<=0){
            if(target ==0){
                returnVal.add(new ArrayList(currPath));
            }
            return;
        }
        
        for(int i= currIdx; i< candidates.length; i++){
            currPath.add(candidates[i]);
            
            backtrack(i, currPath, returnVal, target-candidates[i], candidates);
            
            currPath.remove(currPath.size()-1);
        }
    }
}