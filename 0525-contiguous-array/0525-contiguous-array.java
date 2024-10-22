class Solution {
    /*
    if made it to 0, it is valid.
    1. change all 0 to -1
    2. for iteration:
        update currSum
        update the hashamp<sum, longestIdx>
        calculate difference
        if found sum to be matched to become 0, update maxLength
    return maxLength
    */
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        
        // 1. change all 0 to -1
        for(int i=0; i< n; i++){
            if(nums[i] == 0){
                nums[i] = -1;
            }
        }
        int currSum = 0;
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        // 2. for iteration:
        for(int i=0; i<n; i++){
        //     update currSum
                currSum = nums[i] + currSum;
        //     calculate difference
        //     if found sum to be matched to become 0, update maxLength                
                if(map.containsKey(currSum)){
                    maxLength = Math.max(maxLength, i - map.get(currSum));
                }
        //     update the hashamp<sum, longestIdx>
                if(!map.containsKey(currSum))
                    map.put(currSum, i);

            }
        // return maxLength
        return maxLength;
        
    }
}