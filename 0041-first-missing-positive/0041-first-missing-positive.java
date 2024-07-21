class Solution {
    /*
    what is present in nums?
    oh okay, so giving the smallest possible. 
    track the numbers to make it cyclic sort.
    
    positive integers - 0,1,2,3,4
    
Input: nums = [3,4,-1,1]
sorted -      [0,1,-1,1]
                2
sort the integer
    do the swapping the elements for the upcoming vals.
    do until reaches the end
    
    by iterating find the smallest number
Output: 2
nums[curr] 0 1 2 
curr      [1,2,0]
 ^
 curr = 1
 
 
curr        0 1 2
nums[curr]  1 2 0
nums[curr] = curr+1

nums[curr-1] = curr
*/
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        // do the swapping the elements for the upcoming vals.
        for(int i=0; i< n; i++){
            int curr = nums[i];
            // do until reaches the end
            while(curr<= n && curr>0 && curr != nums[curr-1]){
                int temp = nums[curr-1];
                nums[curr-1] = curr;
                curr =temp;
            }
        }
        
        // boolean hasN = false;
        for(int i=0; i<n; i++){    
            if(nums[i] != i+1)
                return i+1;
        }
        
        return n+1;
    }
}