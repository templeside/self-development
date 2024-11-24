class Solution {
    /*
    include lower, upper, nums
    nums = [0,1,3,50,75], lower = 0, upper = 99
    
    most left, nums[0]
    if(lower< nums[0])
        lower, nums[0]-1
        
    if(nums[i-1]+1 <= nums[i]-1)
        [nums[i-1]+1, nums[i]-1]
    
    nums[n-1], most right
    if(nums[n-1]+1< nums[n-1])
        nums[n-1]+1, upper
    */
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        if(nums ==null)
            return new ArrayList();
        
        int n = nums.length;
        List<List<Integer>> returnVal = new ArrayList<>();
        if(n==0){
            returnVal.add(List.of(lower, upper));
            return returnVal;
        }
        
        // lower = 1, nums[ 2,...]
        if(lower< nums[0]){
            returnVal.add(List.of(lower, nums[0]-1));
        }
        for(int i=1; i<n; i++){
            int left =  nums[i-1];
            int right = nums[i];
            if(left+1 <= right-1){
                returnVal.add(List.of(left+1, right-1));
            }
        }
        if(nums[n-1]< upper){
            returnVal.add(List.of(nums[n-1]+1, upper));
        }
        return returnVal;
    }
}