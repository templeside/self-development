class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(n <=1 )return;
        k = k%n;
        reverse(0, n-1, nums);
        reverse(0,k-1, nums);
        reverse(k, n-1, nums);
    }
    public void reverse(int a, int b, int[]nums){
        while(a<b){
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
            a++;
            b--;
        }
    }
}