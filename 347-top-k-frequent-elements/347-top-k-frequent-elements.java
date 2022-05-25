class Solution {
    /**
    nums = [1,1,1,2,2,3], k = 2
    
    1 - 3
    2 - 2 
    3 - 1
    
    [1,2]
    priorityQueue - O(Nlog(N))
    
    **/
    public int[] topKFrequent(int[] nums, int k) {
                // <element, count>
        HashMap<Integer, Integer> counter = new HashMap<>();
        
        for(int num: nums){
            counter.put(num, counter.getOrDefault(num,0)+1);
        }
        
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>((a,b)-> b.getValue()- a.getValue());
        
        for(Map.Entry<Integer, Integer> count: counter.entrySet()){
            queue.add(count);
        }
        
        int[] returnVal = new int[k];
        for(int i=0; i<k; i++){
            returnVal[i] = queue.poll().getKey();
        }
        return returnVal;
    }
}