class Solution {
    public int leastInterval(char[] tasks, int k) {
        int intervalCount =0;
        Map<Character, Integer> taskFrequencyMap = new HashMap<>();
        for(char chr: tasks)
            taskFrequencyMap.put(chr, taskFrequencyMap.getOrDefault(chr,0)+1);
        
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a,b)-> b.getValue() - a.getValue());
        
        maxHeap.addAll(taskFrequencyMap.entrySet());
        
        while(!maxHeap.isEmpty()){
            List<Map.Entry<Character, Integer>> waitList = new ArrayList<>();
            int n=k+1;
            for(; n>0 && !maxHeap.isEmpty();n--){
                intervalCount++;
                Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
                if(currentEntry.getValue()>1){
                    currentEntry.setValue(currentEntry.getValue()-1);
                    waitList.add(currentEntry);
                }
            }
            maxHeap.addAll(waitList);
            if(! maxHeap.isEmpty())
                intervalCount +=n;
        }
        return intervalCount;
    }
}