class Solution {
    /*
    if in range 1<= curr <= nums
    sort out
    
    from starting from 1, check has missed or not
    
    return val is n or n+1
    
            [3,4,-1,1]
iterator     ^
    
         0       1
    arr[curr-1] = curr
    arr[curr] = curr+1
    */
    public int firstMissingPositive(int[] nums) {
        int iterator = 0;
        int n = nums.length;
        
        while(iterator<n){
            int curr = nums[iterator];
            
            if(curr>=1 && curr<= n && curr != nums[curr-1]){
                swap(curr-1, iterator, nums);
                continue;
            }
            iterator ++;
        }
        
        for(int i=0; i<n; i++){
            if(nums[i] !=i+1)
                return i+1;
        }
        return n+1;
    }
    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}