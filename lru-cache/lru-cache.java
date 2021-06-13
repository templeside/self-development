class LRUCache {
    class DLinkedNode{
        DLinkedNode next;
        DLinkedNode prev;
        int key;
        int val;
    }
    
    private void removeNode(DLinkedNode node){
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;
        
        prev.next = next;
        next.prev = prev;
    }
    
    private void addNode(DLinkedNode node){
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }
    
    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addNode(node);
    }
    
    private DLinkedNode popTail(){
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
    
    HashMap<Integer, DLinkedNode> cache;
    DLinkedNode head;
    DLinkedNode tail;
    int size;
    int capacity;
    
    public LRUCache(int capacity) {
        this.cache = new HashMap<Integer, DLinkedNode>();
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        this.size = 0;
        this.capacity = capacity;
        
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node ==null) return -1;
        this.moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        
        if(node==null){
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.val = value;
            
            cache.put(key, newNode);
            this.addNode(newNode);
            
            size++;
            
            if(size>capacity){
                DLinkedNode popped = this.popTail();
                cache.remove(popped.key);
                size--;
            }
        }else{
            node.val = value;
            moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 *//////////