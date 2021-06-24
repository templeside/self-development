class MyCircularQueue {
    LinkedList<Integer> map;
    int size;
    public MyCircularQueue(int k) {
        map = new LinkedList<>();
        size = k;
    }
    
    public boolean enQueue(int value) {
        if(map.size()>=size)return false;
        map.add(value);
        return true;
    }
    
    public boolean deQueue() {
        if(map.isEmpty())return false;
        map.removeFirst();
        return true;
    }
    
    public int Front() {
        if(map.isEmpty()) return -1;
        return map.get(0);
    }
    
    public int Rear() {
        if(map.isEmpty()) return -1;
        return map.get(map.size()-1);
    }
    
    public boolean isEmpty() {
        return map.isEmpty();
    }
    
    public boolean isFull() {
        return map.size()== size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */