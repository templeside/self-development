class Solution {
    /*
    Use binary search to find the index, firstClosest, of the closest integer to target.
        Initialize two pointers, left and right, to 0 and nums.length - 1, respectively.
        Calculate the index of the middle pointer, mid, and check:
            If the value pointed to by mid is equal to target, i.e., nums[mid] = target, return mid.
            If nums[mid] < target, move left toward the right.
            If nums[mid] > target, move right toward the left.
    Once we have found the closest element to target, return the index, firstClosest, which points to it.

    */
    public List<Integer> findClosestElements(int[] nums, int k, int target) {
        
        List<Integer> closestElements = new ArrayList<>();

        if (nums.length == k) {
            for (int num : nums) {
                closestElements.add(num);
            }
            return closestElements;
        }

        if (target <= nums[0]) {
            for (int i = 0; i < k; i++) {
                closestElements.add(nums[i]);
            }
            return closestElements;
        }

        if (target >= nums[nums.length - 1]) {
            for (int i = nums.length - k; i < nums.length; i++) {
                closestElements.add(nums[i]);
            }
            return closestElements;
        }

        int firstClosest = binarySearch(nums, target);
        int windowLeft = firstClosest - 1;
        int windowRight = windowLeft + 1;

        while ((windowRight - windowLeft - 1) < k) {

            if (windowLeft == -1) {
                windowRight++;
                continue;
            }

            if (windowRight == nums.length || Math.abs(nums[windowLeft] - target) <= Math.abs(nums[windowRight] - target)) {
                windowLeft--;
            }

            else {
                windowRight++;
            }
        }

        for (int i = windowLeft + 1; i < windowRight; i++) {
            closestElements.add(nums[i]);
        }
        return closestElements;
    }

    public static int binarySearch(int[] array, int target) {
        // initialize the left and the right pointer
        int left = 0;
        int right = array.length - 1;

        // find the first closest element to target while left is less than or equal to right
        while (left <= right) {
            // compute the middle index
            int mid = (left + right) / 2;

            // if the value at mid is equal to target, return mid
            if (array[mid] == target) {
                return mid;
            }

            // if the value at mid is less than target, move left forward
            if (array[mid] < target) {
                left = mid + 1;
            }

            // if the value at mid is greater than target, move right backward
            else {
                right = mid - 1;
            }
        }

        // if the target is not found, return the index where it should be inserted
        return left;
    }
}