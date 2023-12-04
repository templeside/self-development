class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int n = nums.length;
        int min = -1;
        
        for(int i=0; i< n; i++){
            for(int j= i+1; j<n; j++){
                int sum = nums[i]+ nums[j];
                if(sum < k)
                    min = Math.max(min, sum);
            }
        }
        System.out.println(min);

        return min;
    }
}