class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> counter = new HashMap<>();
        for(int num: nums){
            counter.put(num, counter.getOrDefault(num, 0)+1);
            if(counter.get(num)> n/2)
                return num;
        }
        return -1;
    }
}