class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> frequency = new HashMap<Character, Integer>();
        for(char c: s.toCharArray())
            frequency.put(c, frequency.getOrDefault(c, 0)+1);
        
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a,b)-> b.getValue()-a.getValue());
        for(Map.Entry<Character, Integer> entry : frequency.entrySet()){
            maxHeap.add(entry);
        }
        
        if(maxHeap.peek().getValue()> (s.length()+1)/2) return "";
        
        char[] stringArr = s.toCharArray();
        int idx =0;
        while(!maxHeap.isEmpty()){
            Map.Entry<Character, Integer> currEntry = maxHeap.poll();
            for(int i=0; i< currEntry.getValue(); i++){
                stringArr[idx] = currEntry.getKey();
                idx +=2;
                if(idx>=s.length())
                    idx= 1;
            }
        }
        return new String(stringArr);
    }
}