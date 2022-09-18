class Solution {
    /*
    we are planning to find the nums.
    that matches with target 0.
    
    in the brute force way, we can initiate with three forloop, with string "nums[i],nums[j],nums[k]" as hashmap keys.
    sort the nums first(O(N log n)),
    then iterate all of the variables through three for loop.
    if the sum nums[i] + nums[j] + nums[k] matches with 0, save the values.
    
    however, there are duplication of checking current sum.
    instead we can use three pointer for easier approach.
    
    we have three pointers: a,b,c which are all indices of the nums array
    
    it would divide into two forloop.
    first loop:
        iteration with getting the target sum that b,c looking for
        second loop:
            starting with b: a+1 c =n-1
            looking for the matches.
            if tartget == b+c,
                add the function
                b++
                c--
            if sum< b+c
                b++
            if sum> b+c
                c--
    Time complexity: O(N^2)
    Space complexity: O(m) where the size of the valid sums
    */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> returnVal = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        
        for(int a=0; a<n; a++){
            if(a!=0 && nums[a] ==nums[a-1]) // prevent duplication.
                continue;
            
            int targetSum = 0-nums[a];
            int b = a+1;
            int c = n-1;

            while(b<c){
                int bcSum= nums[b]+ nums[c];
                if(bcSum ==targetSum){
                    returnVal.add(List.of(nums[a],nums[b],nums[c]));
                    while(b<c && nums[b] == nums[b+1]) b++;
                    while(b<c && nums[c] == nums[c-1]) c--;
                    b++;
                    c--;
                }
                else if(targetSum>bcSum)
                    b++;
                else
                    c--;
            }
        }
        
        return returnVal;
    }
}