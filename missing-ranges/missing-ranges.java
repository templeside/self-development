class Solution {
    /*
    most left if left != lower, add range(left, nums[0]-1)
    middle
        if nums[i]-nums[i+1] ==1, add nothing
        if nums[i]-nums[i+1] ==2, add range(nums[i]+1)
        else, add range(nums[i]+1, nums[i+1]-1)
    most right if right != right, add range(nums[n-1]+1, right)
    */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> returnVal = new ArrayList<>();
        if(nums.length ==0){
            returnVal.add(getRange(lower,upper));
            return returnVal;
        }
            
        
        if(lower != nums[0])
            returnVal.add(getRange(lower, nums[0]-1));
        
        for(int i=0; i< nums.length-1;i++){
            if(nums[i]+1 != nums[i+1])
                returnVal.add(getRange(nums[i]+1, nums[i+1]-1));
        }
        if(upper !=nums[nums.length-1])
            returnVal.add(getRange(nums[nums.length-1]+1, upper));
        return returnVal;
    }
    public String getRange(int a, int b){
        String returnString = "";
        if(a == b)
            returnString = returnString+b;
        else
            returnString = returnString+a+"->"+b;
        return returnString;
    }
}