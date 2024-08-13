class NumArray {
    int[] prefixed;
    int[] nums;
    /*
    [-2, 0, 3, -5, 2, -1]
    
    -2   0  1   -4 -2  -3
    
    1
    */
    public NumArray(int[] nums) {
        int n = nums.length;
        
        prefixed= new int[n];
        this.nums = nums;
        
        prefixed[0] = nums[0];
        for(int i=1; i< n; i++){
            prefixed[i] = prefixed[i-1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left ==0)
            return prefixed[right];
        else
            return prefixed[right]- prefixed[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */