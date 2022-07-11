class Data{
    String val;
    int time;
    
    Data(String val, int time){
        this.val=val;
        this.time=time;
    }
}
class TimeMap {
/**
Input
["TimeMap", "set", "get", "get", "set", "get", "get"]
[[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
Output
[null, null, "bar", "bar", null, "bar2", "bar2"]

Explanation
TimeMap timeMap = new TimeMap();
timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
timeMap.get("foo", 1);         // return "bar"
timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
timeMap.get("foo", 4);         // return "bar2"
timeMap.get("foo", 5);         // return "bar2"
time stamp는 언제나 항상 증가를 할 것이고 key는 항상 같을 것이다.

그렇기 때문에 array로 timestamp를 구하게 된다면, timestamp는 항상 increasing order일 것이고,
left most value를 구하기 쉬워 질 것이다.
rightMostPrev.

x
timestamp_prev<= timestamp.

**/
    Map<String, List<Data>> map;
    public TimeMap() {
        map= new HashMap<String, List<Data>>();
    }
    
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<Data>());
        }
        // new key
        map.get(key).add( new Data(value, timestamp));
    }
    
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        // if there's same key, find the closest value less than or equal to given timestamp
        return binarySearch(map.get(key), timestamp); 
    }
    
    private String binarySearch(List<Data> list, int time){
        int l=0;
        int r=list.size()-1;
        
        while(l<r){
            int mid= l+(r-l)/2;
            if(list.get(mid).time==time) return list.get(mid).val;
            else if(list.get(mid).time < time){
                if(time< list.get(mid+1).time) return list.get(mid).val; // time between [mid, mid+1]'s time
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return list.get(l).time<=time ? list.get(l).val: "";
    }
}
