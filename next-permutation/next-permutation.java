class Solution {
    /**
    1,2,3
    
    ?? is it backtracking???
    
    because the permutation stars reverse when finished all the right numberse are reversed. 
    
    
    **/
    public void nextPermutation(int[] nums) {
        int pivot = nums.length-2;
        while(pivot>=0 && nums[pivot] >= nums[pivot+1]){
            pivot--;
        }
        if(pivot>=0){
            int min = nums.length-1;
            while(nums[pivot] >= nums[min])
                min --;
            swap(nums, min, pivot);
        }
        reverse(nums, pivot+1);
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void reverse(int[] nums, int i){
        int j=  nums.length-1;
        
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
}