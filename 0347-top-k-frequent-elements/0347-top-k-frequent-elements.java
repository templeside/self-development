class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // keep track of the frequency
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> queue= new PriorityQueue<Map.Entry<Integer,Integer>>((a,b)->a.getValue() -b.getValue());
        // having queue - min heap
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            queue.add(entry);
            if(queue.size()>k)
                queue.poll();
        }
        
        int[] returnVal = new int[queue.size()];
        for(int i=0; i<k; i++)
            returnVal[i] = queue.poll().getKey();
        return returnVal;
    }
}