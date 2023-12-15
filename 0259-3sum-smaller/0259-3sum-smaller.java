class Solution {
    /*
    -2 0 1 3
       ^ ^ ^
    
    target=4
    currSUm = -1 
    */
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        int n = nums.length;
        
        for(int i=0; i< n-2; i++){
            int left  = i+1;
            int right = n-1;
            
            while(left<right){
                int currSum = nums[i]+nums[left]+nums[right];

                if(currSum< target){
                    count +=right-left;
                    left ++;
                }
                else
                    right--;
            }
        }
        return count;
    }
}