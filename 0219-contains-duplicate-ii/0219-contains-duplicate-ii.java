class Solution {
    /*
    3n
    */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n =nums.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j< Math.min(i+k+1,n); j++){
                if(nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }
}