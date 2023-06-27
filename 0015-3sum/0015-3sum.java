class Solution {
    /*
    prevent duplication, make it in order.
    to remove duplicates, use hashSet or do the specific algorithm
    
    having three indicex, keep track of where I am: left, right, middle.
    
    having nums[i]+nums[j]+nums[k] = 0.
    target = -nums[i];
    find the two sum. except the duplicates.
    
    */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> returnVal = new LinkedList<>();
        Arrays.sort(nums);
        int n =nums.length;
        
        int i=0;
        
        while(i< n){
            if(i !=0 && nums[i] == nums[i-1]){
                i++;
                continue;
            }
                
            
            int target = -nums[i];
            int left=i+1;;
            int right = n-1;            
            
            while(left<right){
                int sum = nums[left]+ nums[right];
                if(target == sum){
                    returnVal.add(List.of(nums[i], nums[left], nums[right]));
                    
                    while(left<right && nums[left] == nums[left+1]) left++;
                    while(left<right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                }
                else if(sum< target){ // 3, 5, then shift the right index
                    left++;
                }else{
                    right--;
                }
            }
            i++;
        }
        return returnVal;
    }
}