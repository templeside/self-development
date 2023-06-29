class Solution {
    /*
    using two pointer, update the values.
    
nums = [0,1,0,3,12]
nums = [1,3,12,0,0]
idx             ^
nonzeros        ^        

for(int i=0; i< n; i++)
    if(non zero)
        updateIdx(currIdx, nonzeroIdx)
        currIdx++;
        nonzeroIdx++;
    else
        currIdx++;
        
O(n)
O(1)

instead of finding 0, look for the non zero integers.

    */
    public void moveZeroes(int[] nums) {
        int nonZeroIdx = 0;
        int currIdx=0;
        int n = nums.length;
        
        for(currIdx=0; currIdx<n; currIdx++){
            if(nums[currIdx] !=0){
                updateIdx(currIdx, nonZeroIdx, nums);
                nonZeroIdx++;
            }
        }
    }
    public void updateIdx(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}