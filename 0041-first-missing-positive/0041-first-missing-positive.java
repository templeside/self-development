class Solution {
    /*
    find missing positive
    
    idx 0    val 1
    arr[i] = i+1
    arr[i-1] = i
    
    [1,2,0] - [1 2 0]
    sorting based on iterator
    
    [3,4,-1,1]
    [1,4,-1,3]
    
    while
        if arr[i] != i+1
            swap
            continue
        iterator ++
    */
    public int firstMissingPositive(int[] nums) {
        int iterator = 0;
        int n = nums.length;
        
        while(iterator< n){
            int val = nums[iterator];
            if(val>=1 && val<=n &&  val != nums[val-1]){
                swap(iterator, val-1, nums);
                continue;
            }
            iterator++;
        }
        for(int i=0; i< n; i++){
            if(nums[i] != i+1)
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