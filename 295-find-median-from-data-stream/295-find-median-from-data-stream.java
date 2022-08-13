class MedianFinder {
    public static PriorityQueue<Integer> smallValues;
    public static PriorityQueue<Integer> bigValues;
    
    public MedianFinder() {
        smallValues = new PriorityQueue<>((a,b)-> b-a);   // 2,1
        bigValues = new PriorityQueue<>();     // 3,5,6
    }
    
    public void addNum(int num){
        smallValues.add(num);
        if(smallValues.size()>= bigValues.size()){
          bigValues.add(smallValues.poll());
        }
        if(smallValues.size()< bigValues.size()){
            smallValues.add(bigValues.poll());
        }
    }
    
    public double findMedian() {
        if(bigValues.size()== smallValues.size())
          return ((double)bigValues.peek() + (double) smallValues.peek())/2;
        // System.out.println(bigValues +" "+ smallValues);
        return smallValues.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */