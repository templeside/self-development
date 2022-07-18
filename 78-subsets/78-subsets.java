class Solution {
    /**
    1   2   3   
            ^
    []
    [],[1]
    [],[1],[2],[1,2]
    [],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]
    
    
    i would do cascading. 
    using bfs, adding new variable again and again by the end of the array.
    **/
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        
        for(int i=0; i< nums.length; i++){
            int n = subsets.size();
            for(int j=0; j< n; j++){
                List<Integer> tempSubset = new ArrayList(subsets.get(j));
                tempSubset.add(nums[i]);
                subsets.add(tempSubset);
            }
        }
        return subsets;
    }
}