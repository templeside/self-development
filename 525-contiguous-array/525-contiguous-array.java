class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> count = new HashMap<>();
        count.put(0,-1);
        int max = 0;
        int currCount = 0;
        
        for(int i=0; i< nums.length; i++){
            currCount += nums[i]==1? 1: -1;
            if(count.containsKey(currCount) ){
                max = Math.max(max, i- count.get(currCount));
            }else{
                count.put(currCount, i);
            }
        }
        return max;
    }
}