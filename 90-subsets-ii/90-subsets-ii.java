class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res= new ArrayList<>();
        for(int digit=0; digit<=nums.length; digit++){
            dfs(nums, res, new ArrayList<>(), digit, 0);
        }
        return res;
    }
    
    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> currentSubset, int digit, int start){
        // 1. base case
        if(currentSubset.size()==digit){
            res.add(new ArrayList<>(currentSubset));
            return;
        }
        // 2. combinations
        for(int i=start; i<nums.length; i++){
            // ignore if current number is duplicate
            if(i!=start&& nums[i]==nums[i-1])    //starting index가 아닌 다른 values들과 duplication인지 확인.                
                continue;
           
            currentSubset.add(nums[i]);// add
            dfs(nums, res, currentSubset, digit, i+1); // backtrack
            currentSubset.remove(currentSubset.size()-1); // remove
        }
    }
}