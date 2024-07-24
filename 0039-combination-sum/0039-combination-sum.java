class Solution {
    /*
    all combination sum.
    
    having curr sum, 
    
    base case - when currSum>= targtet
    
    recursion with candidates.
    */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        int currSum = 0;
        int currIdx=0;
        List<Integer> currComb = new ArrayList<>();
        List<List<Integer>> returnComb = new ArrayList<>();
        backtrack(currSum, currIdx, currComb, returnComb, candidates, target);
        
        return returnComb;
    }
    public void backtrack(int currSum,int currIdx,List<Integer> currComb,List<List<Integer>> returnComb, int[] candidates, int target){
        if(currSum == target)
                returnComb.add(new ArrayList(currComb));
        
        for(int i=currIdx; i< candidates.length; i++){
            currSum += candidates[i];
            if(currSum> target)
                continue;
            
            currComb.add(candidates[i]);
            
            backtrack(currSum, i, currComb, returnComb, candidates, target);
            
            currComb.remove(currComb.size()-1);
            currSum -= candidates[i];
        }
    }
}