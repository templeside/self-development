class Solution {
    /*
    cyclic sort - one missing number
    sort it out to list out 
    and find out the val and number
    
    if i==0, val ==1
    arr[i] = i+1
    arr[i-1] == i
    */
    public int[] findErrorNums(int[] nums) {
        int i = 0;
        int n = nums.length;
        
        while(i< n){
            int currVal = nums[i];
            if(currVal != nums[currVal-1]){
                swap(i, currVal-1, nums);
                continue;
            }
            i++;
        }
        
        for(i=0; i< n; i++){
            int curr = nums[i];
            if(i != curr-1){
                return new int[]{curr, i+1};
            }
        }
        return null;
    }
    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}