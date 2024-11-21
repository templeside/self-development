class Solution {
    /*
    hashMap 으로 같은 값을 찾으면 time complexity가 준다.
    */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n =nums.length;
        Map<Integer, Integer> map = new HashMap<>();// nums[i] i-j<=k
        for(int j=0; j<n; j++){
            int curr = nums[j];
            if(map.containsKey(curr) && Math.abs(map.get(curr) - j)<=k)
                return true;
            map.put(curr, j);
        }
        return false;
    }
}