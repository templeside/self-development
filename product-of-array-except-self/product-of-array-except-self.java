class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        boolean zeroIncluded = false;
        boolean multipleZeroIncluded = false;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                if(zeroIncluded)
                    multipleZeroIncluded = true;
                zeroIncluded = true;
                
                continue;
            }
            product= product * nums[i];
        }
        
        for(int i=0;i<nums.length;i++){
            if(zeroIncluded){
                if(multipleZeroIncluded)
                    nums[i] = 0;
                else if(nums[i] == 0)
                    nums[i] = product;
                else
                    nums[i] = 0;
            }else{
                nums[i] = product/nums[i];
            }
        }
        return nums;
    }
}