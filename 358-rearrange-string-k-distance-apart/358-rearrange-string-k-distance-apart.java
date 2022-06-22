class Solution {
    public String rearrangeString(String s, int k) {
        if(k<=1)return s;
        HashMap<Character, Integer> frequencyCounter = new HashMap<>();
        for(char c: s.toCharArray())
            frequencyCounter.put(c, frequencyCounter.getOrDefault(c, 0)+1);
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        maxHeap.addAll(frequencyCounter.entrySet());
        
        Queue<Map.Entry<Character, Integer>> distance = new LinkedList<>();
        
        StringBuilder sb = new StringBuilder();
        
        while(!maxHeap.isEmpty()){
            Map.Entry<Character, Integer> currEntry = maxHeap.poll();
            sb.append(currEntry.getKey());
            currEntry.setValue(currEntry.getValue()-1);
            distance.add(currEntry);
            if(distance.size() == k){
                Map.Entry<Character, Integer> entry= distance.poll();
                if(entry.getValue()>0)
                    maxHeap.add(entry);
            }
        }
        if(sb.length() == s.length())
            return sb.toString();
        else
            return "";
    }
}