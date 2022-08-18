class HitCounter {
    /**
    hits - time stamp.
    
    which mean I need save all the timestamp.
    bruteForce - I can have the intuition on the loop.
    from 
        timestamp - HashMap<time, count>
        what I am going to do is - 
    
    forloop 
    **/
    HashMap<Integer, Integer> map;
    public HitCounter() {
        map = new HashMap<>();
    }
    
    public void hit(int timestamp) {
        map.put(timestamp, map.getOrDefault(timestamp,0)+1);
    }
    
    // loading all of the nodes.
    // hashmap - count all of the values. 
    // if in the time stamp, add to count the stamp.
    public int getHits(int timestamp) {
        int hit= 0;
        
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getKey() > timestamp- 300){
                hit += entry.getValue();
            }
        }
        return hit;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */