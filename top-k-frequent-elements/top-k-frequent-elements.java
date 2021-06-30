class Solution {
    public int[] topKFrequent(int[] nums, int k) {
                // <num, count>
        HashMap<Integer,Integer> map = new HashMap<>();
        for(Integer num: nums){
            if(!map.containsKey(num))
                map.put(num,0);
            map.put(num, map.get(num)+1);
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int num: map.keySet()){
            q.add(new int[]{num, map.get(num)});
        }
        
        int[] ans = new int[k];
        for(int i=0; i<k;i++)
            ans[i] = q.poll()[0];
        return ans;
    }
}