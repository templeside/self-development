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
        int prevMin = nums[0]; // Tracks the minimum product up to the current position
        int prevMax = nums[0]; // Tracks the maximum product up to the current position

        for (int i = 1; i < nums.length; ++i) {
            int num = nums[i];

            if (num < 0) {
                // Swap dpMin and dpMax because multiplying by a negative flips signs
                int temp = prevMax;
                prevMax = prevMin;
                prevMin = temp;
            }

            prevMax = Math.max(num, prevMax * num);
            prevMin = Math.min(num, prevMin * num);

            ans = Math.max(ans, prevMax); // Update the answer with the maximum product found so far
        }
        return ans;
    }
}
