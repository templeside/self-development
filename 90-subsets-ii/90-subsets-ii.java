class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> subsets = new ArrayList<>();
        
        subsets.add(new ArrayList<>());
        int startIdx =0, endIdx=0;
        
        for(int i=0; i< nums.length; i++){
            startIdx=0;
            
            if(i>0 && nums[i] == nums[i-1])
                startIdx = endIdx+1;
            endIdx = subsets.size()-1;
            
            for(int j= startIdx; j<= endIdx; j++){
                List<Integer> subset = new ArrayList<>(subsets.get(j));
                subset.add(nums[i]);
                subsets.add(subset);
            }
        }
        return subsets;
    }
}