class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for(int num: nums){
            counter.put(num, counter.getOrDefault(num,0)+1);
        }
        
        PriorityQueue<Integer> queue = new PriorityQueue((a,b)-> counter.get(b) - counter.get(a));
        for(int key: counter.keySet()){
            // System.out.println(new int[]{key, (int)counter.get(key)});
            queue.add(key);
        }
        
        int[] returnVal = new int[k];
        for(int i=0;i<k;i++){
            int val = queue.poll();
            returnVal[i] = val;
        }
        return returnVal;
    }
}