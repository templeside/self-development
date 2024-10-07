class Solution {
    /*
    kth largest
    keep the largest heap
    
    if i pop, iwould get kth element
    */
    public int findKthLargest(int[] nums, int k) {
        if(nums.length< k)
            return -1;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)-> a-b);
        for(int num: nums){
            queue.add(num);
            if(queue.size()> k)
                queue.poll();
        }
        return queue.poll();
    }
}