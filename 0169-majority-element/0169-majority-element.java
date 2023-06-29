class Solution {
    /*
    I can do hashmap for checking the frequency.
    O(N)
    O(N)
    
    1. majority element
    
    */
    public int majorityElement(int[] nums) {
        int majorityElement=0;
        int majorityFrequency=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
            if(majorityFrequency< map.get(num)){
                majorityElement = num;
                majorityFrequency = map.get(num);
            }
        }
        return majorityElement;
    }
}