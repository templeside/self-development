class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        // 1. using prev starting from lower-1, iterate the value gettting the range of the integer array.
        
        List<String> res = new ArrayList<>();
        int prev = lower-1;
        
        for(int i=0; i<= nums.length; i++){
            int curr = i==nums.length? upper+1: nums[i];
            if(prev+1 <= curr-1){
            String range = RangeCalculate(prev+1, curr-1);
            res.add(range);
            }
            prev= curr;

        }
        return res;
    }
    
    private String RangeCalculate(int left, int right){
        if( left== right)
            return String.valueOf(left);
        return left +"->"+right;
    }
}