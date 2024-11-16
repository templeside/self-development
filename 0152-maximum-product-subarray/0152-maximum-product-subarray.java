class Solution {
    /**
    nums = [2, 3, -2, 4]
    pointer       ^
    dpMax    2   6   -2  4
    dpMin    2   3  -12 -48

    ans = 6

    By swapping dpMin and dpMax when nums[i] is negative, we ensure that the maximum and minimum products are correctly updated.
    **/
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int dpMin = nums[0]; // Tracks the minimum product up to the current position
        int dpMax = nums[0]; // Tracks the maximum product up to the current position

        for (int i = 1; i < nums.length; ++i) {
            int num = nums[i];

            if (num < 0) {
                // Swap dpMin and dpMax because multiplying by a negative flips signs
                int temp = dpMax;
                dpMax = dpMin;
                dpMin = temp;
            }

            dpMax = Math.max(num, dpMax * num);
            dpMin = Math.min(num, dpMin * num);

            ans = Math.max(ans, dpMax); // Update the answer with the maximum product found so far
        }
        return ans;
    }
}
