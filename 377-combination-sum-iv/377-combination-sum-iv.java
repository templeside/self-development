class Solution {

    public int combinationSum4(int[] nums, int target) {
        int currIdx=0;
        int currSum=0;
        HashMap<Integer, Integer> memo = new HashMap<>();
        
        return backtrack(memo, currIdx, currSum, nums, target);
    }
    /**
    [1 2 3] target = 4
    
    **/
    public int backtrack(HashMap<Integer,Integer> memo, int currIdx, int currSum, int[] nums,int target){
        if(currSum>=target){
            if(currSum == target)return 1;
            return 0;
        }
        if(memo.containsKey(currSum))return memo.get(currSum);
        
        int count = 0;
        for(int i=0; i< nums.length; i++){
            count += backtrack(memo, i, currSum+ nums[i], nums, target);
        }
        memo.put(currSum, count);
        
        return memo.get(currSum);
    }
}