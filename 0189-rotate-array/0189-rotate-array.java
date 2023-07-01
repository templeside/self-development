class Solution {
    /*
    we can have the linked list that is easier access to insert and remove
    with time complexity of O(n)
    
    instead, we can do in place transfer.
    
    rotate: ->
    nums = [1,2,3,4,5,6,7], k = 3
    nums = [7,1,2,3,4,5,6]
    nums = [6,7,1,2,3,4,5]
    nums = [5,6,7,1,2,3,4]
    
    takes too much time.
    while we are looking at the steps, the last digit is incrementing in reverse order.
    and reverse(reverse(nums)) = inorder.
    how about reverse & reverse in two steps?
    1. reverse all
    2. reverse divide partially 

    reversed = [7,6,5 | 4,3,2,1]
if we reverse in two part: 
    reversed = [5,6,7 | 1,2,3,4]

    */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        reverse(0, n-1, nums);
        reverse(0, k-1, nums);
        reverse(k, n-1, nums);
        
    }
    //reverse (starting point, end point, nums)
    public void reverse(int startIdx, int endIdx, int[] nums){
        while(startIdx<endIdx){
            int tempVal = nums[startIdx];
            nums[startIdx] = nums[endIdx];
            nums[endIdx]= tempVal;
            startIdx++;
            endIdx--;
        }
    }
}