class Node{
    Node prev;
    Node next;
    int key;
    int value;
    
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
class LRUCache {
    /**
    cacheCapacity
    cacheSize
    head
    tail 
    **/
    int cacheCapacity;
    int cacheCurrSize;
    Node head;
    Node tail;
    HashMap<Integer, Node> map;
    
    public LRUCache(int capacity) {
        cacheCapacity = capacity;
        cacheCurrSize = 0;
        
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;

        map =new HashMap<>();
    }
    
    public int get(int key) {
        if(! map.containsKey(key))return -1;
        
        Node currNode = map.get(key);
        // remove from the currNode and add onto the tail.
        currNode.prev.next = currNode.next;
        currNode.next.prev = currNode.prev;

        //adding to the front
        Node headNext = head.next;
        headNext.prev = currNode;
        currNode.prev = head;
        currNode.next = headNext;
        head.next = currNode;

        return currNode.value;
    }
    
    /**
    capacity = 2
    head - {2,2} - {1,1} - tail
    **/
    public void put(int key, int value) {
        // if containsKey already
        if(map.containsKey(key)){
            // find out the node and connects prev and next nodes.
            Node currNode = map.get(key);
            // remove from the currNode and add onto the tail.
            currNode.prev.next = currNode.next;
            currNode.next.prev = currNode.prev;
            
            //adding to the front
            Node headNext = head.next;
            headNext.prev = currNode;
            currNode.prev = head;
            currNode.next = headNext;
            head.next = currNode;
            
            currNode.value = value;
        }
        // if not containsKey
        else{
            // create the nodes and add to tail.
            Node currNode = new Node(key, value);
            map.put(key, currNode);
            // adding to the front. 
            Node headNext = head.next;
            headNext.prev = currNode;
            currNode.prev = head;
            currNode.next = headNext;
            head.next = currNode;
            
            cacheCurrSize ++;
            // if size different,
            if(cacheCurrSize> cacheCapacity){
                // remove the head next node.
                Node tailPrev = tail.prev;
                tailPrev.prev.next = tail;
                tail.prev = tailPrev.prev;
                cacheCurrSize--;
                map.remove(tailPrev.key);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */