class Solution {
    public List<List<Integer>> combine(int n, int k) {
        // n is unique
        // 1. return val.
        List<List<Integer>> returnVal = new ArrayList<>();
        // backtracking
        List<Integer> currList = new ArrayList<>();
        dfs(0, n, currList, k, returnVal);
        
        return returnVal;
    }
    
    public void dfs(int currNum,int n, List<Integer> currList, int k, List<List<Integer>> returnVal){
        if(currList.size()== k){
            returnVal.add(new ArrayList<>(currList));
            return;
        }
                
        for(int i=currNum+1; i<=n; i++){
            if(!currList.contains(i)){
                currList.add(i);
                dfs(i,n, currList, k, returnVal);
                currList.remove(currList.size()-1);
            }
        }
    }
}