class Solution {
    /*
    [-4,-1,-1,0,1,2]
i        ^
j             ^
k               ^
[-1,-1,2] [ ]
    */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> returnVal = new ArrayList();
        Set<String> visited = new HashSet<>();
        
        for(int i=0; i<n-2; i++){
            int j = i+1; 
            int k = n-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum ==0){
                    String val = nums[i]+","+nums[j]+","+nums[k];
                    if(!visited.contains(val)){
                        returnVal.add(List.of(nums[i], nums[j], nums[k]));
                        visited.add(val);
                    }
                    j++;
                    k--;
                }
                    
                else if(sum> 0)
                    k--;
                else
                    j++;
            }
        }
        return returnVal;
    }
}