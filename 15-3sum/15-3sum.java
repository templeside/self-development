class Solution {
    /**
    3sum -sorted, and compare - left right, two pointer, - to check is there a target number 0.
    **/
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> returnVal = new ArrayList<>();
        
        for(int i=0; i<nums.length-2; i++){
            if(i ==0 || nums[i] !=nums[i-1]){
                int j = i+1;
                int k = nums.length-1;

                while(j< k){
                    int sum = nums[i]+nums[j]+nums[k];

                    if(sum ==0 ){
                        returnVal.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while(j<k && nums[j] == nums[j+1]) j++;
                        while(j<k && nums[k] == nums[k-1]) k--;
                        j++;
                        k--;
                    }
                    else if(sum>0){
                        while(j<k && nums[k] == nums[k-1]) k--;
                        k--;
                    }else{
                        while(j<k && nums[j] == nums[j+1]) j++;
                        j++;
                    }
                }
            }
        }
        
        return returnVal;
    }
}