class Solution {
    /*
    ->         0 1 2 3 4 5 6
Input: nums = [1,2,3,4,5,6,7], k = 3
                
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
                              0 1 2 3 4 5 6
rotate 3 steps to the right: [5,6,7,1,2,3,4]

idx nums[0] -> nums[3]
nums[i] -> nums[i+k]
idx num[5] -> nums[5+3 %7]
nums[i] -> nums[(i+k)%n]
for loop: 
    nums[i] -> nums[(i+k)%n]

        0 1 2 3 4 5 6
nums = [1,2,3,4,5,6,7], k = 3
              ^
        4 3 2 1 7 6 5 
        5 6 7 1 2 3 4
nums = [1,2,3,4,5,6,7], k = 3            

1

shifting each. O(KN), O(1)
how about shifting right away?
those takes an array.
instead i can use reverse to reverse the array partially for better approach

[-1,-100,3,99] 2
[3 -100 -1, 99]

    */
    public void rotate(int[] nums, int k) {
        k = k%(nums.length);
        reverse(0, nums.length-1, nums);
        reverse(0,k-1, nums);
        reverse(k, nums.length-1, nums);
        
    }
    public void reverse(int l, int r, int[] nums){
        while(l<r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}