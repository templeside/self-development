class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue =new PriorityQueue<>((a,b)-> (a[0]+a[1]-(b[0]+b[1])));
        
        for(int i=0; i< nums1.length; i++){
            queue.add(new int[]{nums1[i], nums2[0], 0});
        }
        
        List<List<Integer>> returnVal = new ArrayList<>();
        for(int i=0; i<k; i++){
            int[] curr = queue.poll();
            returnVal.add(List.of(curr[0],curr[1]));
            
            int nums2Val = curr[1];
            int nums2Idx = curr[2];
            if(nums2Idx<nums2.length-1)
                queue.add(new int[]{curr[0], nums2[nums2Idx+1], nums2Idx+1});
        }
        return returnVal;
    }
}