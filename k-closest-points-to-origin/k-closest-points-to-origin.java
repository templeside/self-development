class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        for(int[] point: points){
            int[] temp = new int[]{point[0] * point[0] + point[1]*point[1], point[0],point[1]};
            q.add(temp);
        }
        
        // while(!q.isEmpty()){
        //     int[] t = q.poll();
        //     System.out.println(t[0] +" "+t[1]+" "+t[2]);
        // }
        
        int[][] ans = new int[k][];
        for(int i=0; i<k; i++){
            int[] temp =q.poll();
            ans[i] = new int[]{temp[1],temp[2]};
        }
        return ans;
    }
}