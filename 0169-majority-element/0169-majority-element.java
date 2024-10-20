class Solution {
    /*
    can use the hashmap.
    
    better than that,
    
    
    모두 합친거 보다 majority가 더 많다.
    그렇다면, majority count > others
    
    if i have majority count, it makes sense.
    
    if majority,
        majorityCount ++;
    if not majority
        majorityCount --;
        if majorityCount <0
            update majority
            
nums = [2,2,1,1,1,2,2]
                    ^
majority = 2
majorityCount = -1
    */
    public int majorityElement(int[] nums) {
        int n = nums.length;
        if(n==1)
            return nums[0];
        int majorityCount = 1;
        int majority = nums[0];
        
        for(int i=1; i< n;i++){
            int currNum = nums[i];
            if(majority == currNum)
                majorityCount++;
            else
                majorityCount--;
            
            if(majorityCount<0){
                majorityCount=1;
                majority = currNum;
            }
        }
        return majority;
    }
}