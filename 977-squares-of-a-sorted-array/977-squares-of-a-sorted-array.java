class Solution {
    /**
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

brute force:
1. square values [16, 1,0,9,100]
2. sort the values [0, 1 , 9, 16, 100]
Time complexity: O(N log N) sorting 

how about two poitners?
1. with two pointers, prepare the positive number vs negative number.
2. compare those values, bigger is added to the new sorted array.

ex)
Input: nums = [-4,-1,0,3,10]
left                 ^
right                  ^
1. 16 vs 100 -> newNums[100]                
2. 16 vs 9  ->  newNums[16, 100]
3. 1 vs 9 ->    newNums[9, 16, 100]
4. 1 vs 0 ->    newNums[1, 9, 16, 100]
5. 0 vs 0 ->    newNums[0, 1, 9, 16, 100]

left<= right 

Output: [0,1,9,16,100]

Time complexity: O(N)
space complexity :O(N) 
    **/
    public int[] sortedSquares(int[] nums) {
        LinkedList<Integer> newNums = new  LinkedList<>();
        int n = nums.length;
        int left=0, right = n-1;
        
        while(left<= right){
            int leftVal = nums[left];
            int rightVal = nums[right];
            int addingIdx = right;
            //check left should be negative.
            if(leftVal <0){
                if(leftVal * leftVal > rightVal*rightVal){
                    addingIdx = left;
                    
                    newNums.add(0, leftVal*leftVal);
                    left++;
                    continue;
                }
            }
            newNums.add(0, rightVal*rightVal);
            right--;
        }
        for(int i=0; i< n; i++){
            nums[i] = newNums.get(i);
        }        
        return nums;
    }
}