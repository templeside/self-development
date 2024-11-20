class Solution {
    /*
    so, i can use the cyclic array approach .
    
    data structure - nothing.
    reverse entire array
    reverse(0,k-1)(k, n-1)
    */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        if(n ==1)
            return;
        reverse(0, n-1, nums);
        reverse(0, k-1, nums);
        reverse(k, n-1, nums);
    }
    public void reverse(int left, int right, int[] nums){
        while(left<right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}