class Solution {
    /*
    [3,3,4]
    
    
    */
    public int majorityElement(int[] nums) {
        int count = 0;
        int majority = nums[0];
        
        for(int num : nums){
            majority = count ==0? num: majority;
            
            if(majority == num)
                count++;
            else
                count--;
            
            
        }
        return majority;
    }
}