class Solution {
    /**
brute force way - timecomplexity: O(N logN)
Input: nums = [-4,-1,0,3,10]
newNums = [16,1,0,9,100]
sort(newNums) = [0,1,9,16,100]

    [16,1,0,9,100]
left^
right               ^
output = [0, 1, 9, 16, 100]

    [16,1,0,9,100]
left        ^
right     ^
output = [0,1,9,16,100]

O(N) 
    **/
    public int[] sortedSquares(int[] nums) {
        int[] newNum = new int[nums.length];
        int left=0, right=nums.length-1;
        
        for(int newIdx= nums.length-1; newIdx>=0 ; newIdx--){
            
            if(nums[left] <0 && nums[left]*nums[left] > nums[right]*nums[right]){
                newNum[newIdx] = nums[left]*nums[left];
                left ++;
            }else{
                newNum[newIdx] = nums[right]*nums[right];
                right --;
            }
        }
        return newNum;
    }
}