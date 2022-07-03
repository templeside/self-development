class Solution {
    /**
    for(int i=0; i< nums.length; i++){
        for(int j=i+1; j< nums.length; j++){
            for(int k = j+1; nums.length; j++){
                nums[i]+nums[j]+nums[k] == 0 
                returnArr.add (i,j,k);
            }
        }
    }
    time complexity: O(N^3). 
    0. sorted
    1. iterate through the nums, nums[i] = a.
    2. find out -a in the second loop. two sum.
    

    
Input: nums = [-4,-1,-1,0,1,2]
pivot                   ^            +1
left[pivot+1]             ^
right[length-1]           ^        -1,2

-1,-1,2 -1,0,1

Output: [[-1,-1,2],[-1,0,1]]

edge cases = duplicated values, increment it.

time complexity: O(N^2)
    **/
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3) return new ArrayList<>();
        
        List<List<Integer>> returnVal = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int pivotIdx = 0; pivotIdx < nums.length-2; pivotIdx++){
            int target = 0- nums[pivotIdx];
            
            int left = pivotIdx+1;
            int right = nums.length-1;
            
            while(left< right && (pivotIdx == 0 || nums[pivotIdx] != nums[pivotIdx-1])){
                int sum = nums[left]+nums[right];
                if(sum == target){
                    List<Integer> temp = (List.of(nums[pivotIdx], nums[left], nums[right]));

                    
                    returnVal.add(temp);
                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                }
                else if(sum> target){
                    right--;
                }
                else{
                    left++;
                }
            }
            
        }
        return returnVal;
    }
}