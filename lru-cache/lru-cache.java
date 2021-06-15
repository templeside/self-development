class LRUCache {
    class DLinkedList{
        DLinkedList prev;
        DLinkedList next;
        int key;
        int val;
    }
    HashMap<Integer, DLinkedList> map;
    DLinkedList head;
    DLinkedList tail;
    int size;
    int capacity;
    public LRUCache(int capacity) {
        this.map = new HashMap<Integer, DLinkedList>();
        this.size = 0;
        this.capacity = capacity;
        this.head = new DLinkedList();
        this.tail = new DLinkedList();
        
        this.head.next = tail;
        this.tail.prev = head;
    }
    
    public int get(int key) {
        DLinkedList node = map.get(key);
        if(node == null) return -1;
        this.moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){                   //when have the node already
            DLinkedList node = map.get(key);
            node.val = value;
            this.get(key);
        }else{
            DLinkedList newNode = new DLinkedList();
            newNode.key = key;
            newNode.val = value;
            
            map.put(key,newNode);
            this.addNode(newNode);
            size++;
            
            if(size>capacity){
                DLinkedList removedNode = removeTail();
                map.remove(removedNode.key);
                size--;
            }
        }
    }
    
    private void moveToHead(DLinkedList node){
        this.removeNode(node);
        this.addNode(node);
    }
    
    private void removeNode(DLinkedList node){
        DLinkedList prev = node.prev;
        DLinkedList next = node.next;
        
        prev.next = next;
        next.prev = prev;
    }
    
    private void addNode(DLinkedList node){
        node.next = head.next;
        node.prev = head;
        
        head.next.prev = node;
        head.next= node;
    }
    private DLinkedList removeTail(){
        DLinkedList removedNode = tail.prev;
        removeNode(removedNode);
        return removedNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */