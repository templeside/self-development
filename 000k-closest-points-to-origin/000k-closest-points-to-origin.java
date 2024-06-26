class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue= new PriorityQueue<>((a,b)-> (a[0]*a[0] +a[1]*a[1] -b[0]*b[0]-b[1]*b[1]) );
        for(int[] point: points){
            queue.add(point);
        }
        int[][] returnVal = new int[k][];
        for(int i=0; i< k; i++)
            returnVal[i] = queue.poll();
        return returnVal;
    }
}