class Solution {
    /*
            [0,1,0,3,12]
            [1,0,0,3,12]
            [1,3,12,0,0]
nonzeroIdx       ^
currIdx               ^

if found nonzero, swap.
    currIdx++
    nonzeroIdx++
else
    currIdx++
    */
    public void moveZeroes(int[] nums) {
        int nonzeroIdx = 0;
        int currIdx = 0;
        
        for(; currIdx<nums.length; currIdx++){
            int curr = nums[currIdx];
            // if found nonzero, swap.
            if(curr !=0){
                swap(currIdx, nonzeroIdx, nums);
            //     currIdx++
            //     nonzeroIdx++
                nonzeroIdx ++;
                continue;
            }else{
            // else
            //     currIdx++
                continue;
            }
        }
    }
    public void swap(int i, int j, int[]nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}