class Solution {
    /*
    having the kth largest elemetn in an array
    priorityqueue
    smallest만처리해야함.
    3,2,1,5,6,4
    q -    5 6 
    */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue= new PriorityQueue<>();
        
        for(int num: nums){
            queue.add(num);
            if(queue.size()>k)
                queue.poll();
        }
        return queue.poll();
    }
}