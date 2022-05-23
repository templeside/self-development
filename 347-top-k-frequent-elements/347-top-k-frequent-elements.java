class Solution {
    /**
    so I am planning on using the count as an index and trying to get the values as a 
    through the hash map, I am counting up the numbers.
    
    ex)
    Input: nums = [1,1,1,2,2,3], k = 2
    1-3
    2-2
    3-1
    
    I can list out the maps as a int array<count, value>
    which means 
    3-1
    2-2
    1-3
    
    1,2
    Output: [1,2]

    **/
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length];
        
        for(int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        
        for(int key : map.keySet()){
            int idx = map.get(key)-1;
            if(bucket[idx] ==null)
                bucket[idx] = new ArrayList<>();
            bucket[idx].add(key);
        }
        
        
        // for(int i=0; i<bucket.length;i++)
            // System.out.println(bucket[i]);
        
        int answerIdx = 0;
        
        int[] answer = new int[k];
        for(int i= bucket.length-1; i>=0 && answerIdx<k; i--){
            if(bucket[i] !=null){
                for(int num: bucket[i]){
                    answer[answerIdx] = num;
                    answerIdx++;    
                }
                
            }
        }
        return answer;
    }
}