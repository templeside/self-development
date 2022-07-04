class Solution {
    /**
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

그냥 iteration을 통해서 풀면 안되는 것인가????
for(int i=0; i< n; i++){
    prod = 1;
    for(int j=0; j< n; j++){
        if(i!=j) 
            prod *=nums[j];
    }
}
Time complexity: O(N^2)

can do better if we already save the prod.
0 is the bomb. it eliminate when the values are more than 0.
1. iteration. find 0 count, all product except 0
2. for iteration, divide by each num, set the value.

    **/
    public int[] productExceptSelf(int[] nums) {
        int zeroCount =0;
        int prod = 1;
        
        for(int num: nums){
            if(num ==0){
                zeroCount ++;
            }else
                prod*=num;
        }
        
        if(zeroCount >1){
            for(int i=0; i< nums.length; i++)
                nums[i] = 0;
        }
        
        else if(zeroCount ==1) {    // when one zero.
            for(int i=0; i< nums.length; i++){
                if(nums[i] == 0)
                    nums[i] = prod;
                else
                    nums[i] = 0;
            }
        }
        
        else{       // when no zero.
            for(int i=0; i< nums.length; i++){
                nums[i] = prod/nums[i];
            }            
        }

        return nums;
    }
}