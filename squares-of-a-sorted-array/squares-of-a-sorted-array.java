class Solution {
    public int[] sortedSquares(int[] nums) {
        Queue<Integer> q = new PriorityQueue<>();
        for(int num: nums)
            q.add(num*num);
        
        int[] res = new int[nums.length];
        for(int i=0; i< nums.length;i++)
            res[i] = q.poll();
        
        return res;
            
    }
}