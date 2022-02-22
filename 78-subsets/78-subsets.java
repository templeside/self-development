class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>  returnVal = new LinkedList<>();
        
        //nums, curridx, subsetArr, returnArr
        backtrack(nums, -1, new LinkedList<>(), returnVal);    
        
        return returnVal;
    }
    
    public void backtrack(int[] nums, int curridx, LinkedList<Integer> subsetArr, List<List<Integer>> returnVal){
        if(curridx >=nums.length)
            return;
        
        returnVal.add(new LinkedList(subsetArr));
        
        for(int i = curridx+1; i<nums.length;i++){
            subsetArr.add(nums[i]);
            backtrack(nums, i, subsetArr, returnVal);
            subsetArr.removeLast();
        }
    }
}