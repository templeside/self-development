class SparseVector {
    // get rid of 0s. 
    // put into hashmap
        // <idx, val>
    public HashMap<Integer, Integer> map;
    SparseVector(int[] nums) {
        map = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            int num = nums[i];
            if(num!=0)
                map.put(i, num);
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int sum=0;
        for(int idx : map.keySet()){
            if(vec.map.containsKey(idx))
                sum += map.get(idx)*vec.map.get(idx);
        }
        return sum;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);