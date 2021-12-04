class Solution {
    public int longestOnes(int[] nums, int k) {
        int right = 0;
        int left= 0;
        while(right <nums.length){
            if(nums[right] ==0) k--;
            if(k<0) {
                if(nums[left] ==0)
                    k++;
                left++;
            }
            right++;
        }
        return right- left;
    }
}