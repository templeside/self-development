class LRUCache {
    class ListNode{
        int key;
        int value;
        ListNode prev;
        ListNode next;
        public ListNode(){
            key = 0;
            value = 0;
            prev = null;
            next = null;
        }
    }
            //<key, listNode>
    HashMap<Integer, ListNode> map;
    private int size, capacity;
    private ListNode head, tail;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        size = 0;
        this.capacity = capacity;
        
        head = new ListNode();
        tail = new ListNode();
        
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))return -1;
        
        ListNode node = map.get(key);
        this.moveToHead(node);
        
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.get(key).value = value;
            this.moveToHead(map.get(key));
        }else{
            ListNode newNode = new ListNode();
            newNode.key = key;
            newNode.value = value;
            
            map.put(key, newNode);
            this.addNode(newNode);
            size ++;
            
            if(size>capacity){
                ListNode removed = removeLate();
                map.remove(removed.key);
                size --;
            }
        }
    }
    private void moveToHead(ListNode node){
        this.removeNode(node);
        this.addNode(node);
    }
    
    private void removeNode(ListNode node){
        ListNode prev = node.prev;
        ListNode next = node.next;
        
        prev.next = next;
        next.prev = prev;
    }
    
    private void addNode(ListNode node){
        node.next = head.next;
        node.prev = head;
        
        head.next.prev = node;
        head.next = node;
    }
    private ListNode removeLate(){
        ListNode removed = tail.prev;
        removed.prev.next= tail;
        tail.prev = removed.prev;
        return removed;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */