class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> contains = new HashSet<>();
        for(int num: nums){
            if(contains.contains(num))return true;
            
            contains.add(num);
        }
        return false;
    }
}