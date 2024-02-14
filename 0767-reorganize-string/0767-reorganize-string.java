class Solution {
    /*
    aaabb
    3 > 2
    aabb
    aaab
    */
    public String reorganizeString(String s) {
        char[] returnArr = new char[s.length()];
        Map<Character, Integer> freq=  new HashMap<>();
        for(char c: s.toCharArray()){
            freq.put(c, freq.getOrDefault(c, 0)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a,b)-> (b.getValue()- a.getValue()));
        
        for(Map.Entry<Character, Integer> entry: freq.entrySet()){
            queue.add(entry);
        }
        
        if(queue.peek().getValue() > (s.length()+1)/2)
            return "";
        
        int ptr = 0;
        
        while(!queue.isEmpty()){
            Map.Entry<Character, Integer> e = queue.poll();
            for(int i=0; i< e.getValue(); i++){
                returnArr[ptr] = e.getKey();
                ptr +=2;
                if(ptr>= s.length())
                    ptr = 1;
            }
        }
        return new String(returnArr);
    }
}