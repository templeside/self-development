class Solution {
    /**
    largest subset - good sign of dynamic programming.
    I would sort the array in sorted order - so that I dont' need to 
    
    starting from the idx 0, to the end of the idx, find out is there any divisible values.
    
    ex)
    Input: nums = [1,2,3]
    idx =          0,1,2
                       ^ 
    1 2,1 3,1
    
    max(list.size()) = [3,1] or [1,2]
    **/
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n= nums.length;
        if(n==0)return null;
        Arrays.sort(nums);
        List<Integer>[] subsetArr = new List[n];
        
        for(int i=0; i< n; i++){
            List<Integer> currList = new LinkedList<>();
            int curr = nums[i];
            currList.add(curr);
            
            for(int j=0;j<i;j++){
                int prev = nums[j];
                if(curr%prev ==0){
                    if(currList.size()< subsetArr[j].size()+1){
                        currList = new LinkedList<>(subsetArr[j]);
                        currList.add(curr);
                    }
                }
            }
            subsetArr[i] = currList;
        }
        
        List<Integer> returnVal = new LinkedList<>();
        
        for(int i=0; i<n; i++){
            returnVal = returnVal.size()>= subsetArr[i].size()? returnVal: subsetArr[i];
        }
        return returnVal;
    }
}