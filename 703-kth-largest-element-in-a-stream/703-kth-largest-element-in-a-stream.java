class KthLargest {
    public PriorityQueue<Integer> increasing;
    public int k;

    public KthLargest(int k, int[] nums) {
        increasing = new PriorityQueue<>();
        this.k = k;

        for(int i=0; i< nums.length; i++){
            increasing.add(nums[i]);
            if(i>=k)
                increasing.poll();
        }
    }
    
    public int add(int val) {
        increasing.add(val);
        if(increasing.size() >k)
            increasing.poll();

        if(increasing.size() ==k)
            return increasing.peek();
        return -1;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
