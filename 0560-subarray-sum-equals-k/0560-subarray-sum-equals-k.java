class Solution {
    /*
    hashmap<diff, count>
    
    find offset = currsum -k 
    add to the count
    
    update hashmap
    
    subarray = nums[0]+ nums[1] + nums[2] + nums[3]+...nums[n-1]
    prefix = nums[0]+ nums[1]...nums[i]
    subarray = nums[3]
    
        [1,2,3]
         ^
k=          3
currSum =   1
offset =    3-1 = 
prefixed    0:1 1:
count=0
    */
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> prefixed =new HashMap<>();
        int count = 0;
        int currSum = 0;
        prefixed.put(0,1);
        
        for(int i=0; i<n; i++){
            currSum += nums[i];
            int offset = currSum-k;
            
            if(prefixed.containsKey(offset))
                count += prefixed.get(offset);
            
            prefixed.put(currSum, prefixed.getOrDefault(currSum, 0)+1);
        }
        return count;
    }
}