class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int currSum = 0;
        
        for(int i=0; i< nums.length;i++){
            currSum += nums[i];
            
            if(k!=0)
                currSum =currSum%k;
            Integer prev = map.get(currSum);
            
            if(prev!=null){
                if(i-prev>1)
                    return true;
            }else
                map.put(currSum,i);
        }
        return false;
    }
}