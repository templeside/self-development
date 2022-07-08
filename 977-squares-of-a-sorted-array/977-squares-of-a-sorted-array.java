class Solution {
    /**
    다 square 해버려서 sor 해버리면 된다.
    O(N log N).
    However, I can do better because it is already sorted.
    which means, if I know the 0, then I can do a better solution because
    
    negative values are becoming positive if squaring.
    
    what I will do is using two pointers, I can do better solution.
    
Input: nums = [-4,-1,0,3,10]
                ^         ^
Input: nums = [-4,-1,0,3,10]
                ^      ^
Input: nums = [-4,-1,0,3,10]
                     ^ 
                     ^
[0, 1,9,16,100]
1. while having negative numbers, compare with postivie numbers.
2. after no negative numbers, fill out the variables in the array.

Output: [0,1,9,16,100]

    ex)
    
    **/
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length-1;
        
        int[] returnVal = new int[nums.length];
        for(int i= nums.length-1; i>=0 ;i--){
            int negative = nums[left];
            int positive = nums[right];
            
            if(negative <0){
                
                //compare
                if(negative * negative >= positive*positive){
                    returnVal[i] = negative * negative;
                    left++;
                    continue;
                }
            }
            returnVal[i] = positive*positive;
            right--;
        }
        return returnVal;
    }
}