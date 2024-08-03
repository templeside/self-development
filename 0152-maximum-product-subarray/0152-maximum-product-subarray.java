class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int dpMin = nums[0];
        int dpMax = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            int num = nums[i];
            int prevMin = dpMin;
            int prevMax = dpMax;
            if (num < 0) {
                dpMin = Math.min(prevMax * num, num);
                dpMax = Math.max(prevMin * num, num);
                } else {
                dpMin = Math.min(prevMin * num, num);
                dpMax = Math.max(prevMax * num, num);
            }
            ans = Math.max(ans, dpMax);
        }
        return ans;
    }
}
