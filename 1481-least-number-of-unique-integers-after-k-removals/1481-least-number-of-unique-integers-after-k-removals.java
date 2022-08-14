class Solution {
    /**
    what is unique after removing k???
    
    what is the removing criteria?
    
    to find the least number of unique integers.
    
    if removing the least frequency of numbers will result into the least number of unique integers.
    why? cuzz have better possibility to remove integers.
    
    1. count frequency with hashmap.
    2. 
    3. decrease the freuqency.
    4. get the size of hashmap or priorityqueue.
    
    [4,3,1,1,3,3,2]
    
    4-1
    2-1
    
    k==-1
    
    1-2
    3-3

    3
    **/
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for(int num: arr)
            frequency.put(num, frequency.getOrDefault(num,0)+1);
        
        PriorityQueue<Map.Entry<Integer,Integer>> increasing = new PriorityQueue<>((a,b)-> a.getValue()-b.getValue());
        for(Map.Entry<Integer, Integer> entry: frequency.entrySet()){
            increasing.add(entry);
        }
        
        while(k>0){
            Map.Entry<Integer, Integer> currFrequency = increasing.peek();
            
            k -= currFrequency.getValue();
            
            if(k>=0)
            increasing.poll();
        }
        return increasing.size();
    }
}