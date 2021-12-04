class MovingAverage {
    // movingaver = size;
    // next = return average of the last size values of the steram.
    // 1.size
    //     values.
    //     total sum of all values
    int[] limitSize_totalSum;// size, totalsum 
    LinkedList<Integer> queue;
    public MovingAverage(int size) {
        limitSize_totalSum = new int[]{size, 0};
        queue = new LinkedList<>();
    }
    
    public double next(int val) {
        queue.add(val);
        limitSize_totalSum[1] += val;
        if(queue.size()> limitSize_totalSum[0]){
            int removed = queue.remove(0);
            limitSize_totalSum[1] -= removed;
        }
        return (double) limitSize_totalSum[1]/ ((double)queue.size());
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */