class Solution {
    /*
    sort the number by cyclic sorting
    iterate and find the first number
    
    if ==n, number
    
    [3,0,1]
    ^
    currVal = 3
    if(nums[currVal] != currVal)
        prev = 
        nums[currVal] = currVal
    */
    public int missingNumber(int[] nums) {
        int iterator = 0;
        
        while(iterator< nums.length){
            int currVal = nums[iterator];
            
            if(currVal !=  iterator && currVal < nums.length){
                swap(currVal, iterator, nums);
                continue;
            }
            iterator++;
        }
        
        for(int i=0; i<nums.length; i++){
            if(i != nums[i])
                return i;
        }
        return nums.length;
    }
    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j ] = temp;
    }
}