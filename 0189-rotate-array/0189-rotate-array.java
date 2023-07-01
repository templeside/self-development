class Solution {
    /*
    we can have the linked list that is easier access to insert and remove
    with time complexity of O(n)
    
    instead, we can do in place transfer.
    */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        List<Integer> maps = new ArrayList<>();
        
        for(int i=n-(k%n); i< n; i++){
            maps.add(nums[i]);
        }
        for(int i=0; i<n-(k%n); i++){
            maps.add(nums[i]);
        }
        
        for(int i=0; i< n; i++)
            nums[i] = maps.get(i);
        
    }
}