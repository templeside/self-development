class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length+1];
        sum[0] = 0;
        for(int i=0; i< nums.length;i++){
            sum[i+1] = sum[i]+ nums[i];
        }
        
        int count=0;
        for(int i=0;i< nums.length;i++){
            for(int j=i; j>=0; j--){
                if( sum[i+1]-sum[j] ==k)
                    count++;
            }
        }
        return count;
    }
}