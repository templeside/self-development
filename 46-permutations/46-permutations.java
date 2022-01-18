class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // 1. returnval
        // 2. visited checker
        
        // 1. iterate through all elements of nums Array 
        // dfs function.
        // if permuatation length == nums.length
            // add the Integer list to returnval
        
        
        List<List<Integer>> returnVal = new ArrayList<>();
        
        dfs(nums, new ArrayList<>(), returnVal);
        
        
        return returnVal;
    }
    
    public void dfs(int[] nums, List<Integer> currList, List<List<Integer>> returnVal){
        if(currList.size() == nums.length){
            returnVal.add(new ArrayList<>(currList));
            return;
        }
        
        for(int i=0;i< nums.length;i++){
            if(!currList.contains(nums[i])){
                currList.add(nums[i]);
                dfs(nums, currList, returnVal);
                currList.remove(currList.size()-1);
            }
                
        }
    }
}