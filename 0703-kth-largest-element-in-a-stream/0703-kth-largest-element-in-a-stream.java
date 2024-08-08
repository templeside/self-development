class KthLargest {
/*
there is no remove
so i am keeping track of only top k elements
minheap - keep track of bigger elemnts
*/
    public PriorityQueue<Integer> queue;
    public int k;
    public KthLargest(int k, int[] nums) {
        queue =new PriorityQueue<>();
        this.k=k;
        for(int num: nums){
            queue.add(num);
            if(queue.size()> k)
                queue.poll();            
        }
    }
    
    public int add(int val) {
        queue.add(val);
        if(queue.size()> k)
            queue.poll();
        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */