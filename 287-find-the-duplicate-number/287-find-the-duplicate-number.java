class Solution {
    /**
    [1,2,3,4,5]
     0 1 2 3 4
             ^
    [1,2,3,4,2],3,4,2,3,4,2
     0 1 2 3 4
       ^
    
    Ialgorithm of the tortoise and hare, 
    
nums[i] = i+1
Input: nums = [1,3,4,2,2]
               0 1 2 3 4 
tortoise       ^
hare           ^
Output: 2

    **/
    public int findDuplicate(int[] nums) {
        int tortoise=nums[0];
        int hare = nums[0];
        
        do{
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        }while(tortoise !=hare);
        
        tortoise = nums[0];
        
        while(tortoise !=hare){
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        return hare;
    }
}