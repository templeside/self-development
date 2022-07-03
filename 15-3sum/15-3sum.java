class Solution {
    /*
    for(int i=0; i< nums.length-2; i++){
        for(int j=i+1; j< nums.length-1; j++){
            for(int k=j+1; k< nums.length; k++){
    }}}
    time complexity: o(N^3)
    
    two sum
    pivot,(for loop)
        two sum ( two pointer)

algorithm:
    1. sort
    2. set my pivot, left, right idx.
    3. compare through, and iterate it.
        pivot = -target. find the target with the left and right index.

Input: nums = [-4,-1,-1,0,1,2]
pivot                   ^
left                      ^
right                     ^
target 0
sum(left+right) 3

returnVal[[-1,-1,2],[-1,0,1]]
Output: [[-1,-1,2],[-1,0,1]]

edge case: 
    1. pivot[i] != pivot[i-1].
    2. figure out my left and right.        
    
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

    */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> returnVal = new ArrayList<>();
        
        Arrays.sort(nums);// O(N log N)
        for(int pivot = 0; pivot< nums.length-2; pivot++){
            if(pivot ==0 || nums[pivot] != nums[pivot-1]){
                int left=pivot+1, right = nums.length-1;
                int target = -nums[pivot];
                
                while(left < right){
                    int sum  = nums[left]+nums[right];
                    if(target == sum){
                        returnVal.add(List.of(nums[pivot], nums[left], nums[right]));
                        while(left<right && nums[left] == nums[left+1]) left ++;
                        while(left< right && nums[right] == nums[right -1]) right --;
                        left++;
                        right--;
                    }
                    else if(target < sum){
                        right --;
                    }
                    else
                        left ++ ;
                }
            }
        }
        return returnVal;
    }
}