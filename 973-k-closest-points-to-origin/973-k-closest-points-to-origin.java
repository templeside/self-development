class Solution {
    /**
    will have max heap to poll all of the values that is longeer.
    time complexity: O(logn) cuz of the returnVal.
    space complexity: O()
    **/
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)-> (b[0]*b[0] +b[1]*b[1]) -(a[0]*a[0] + a[1]*a[1]));
        for(int[] point: points){
            maxHeap.add(point);
            if(maxHeap.size()>k)
                maxHeap.poll();
        }

        int[][] returnVal = new int[k][2];
        for(int i=0; i<k; i++)
            returnVal[i] = maxHeap.poll();
        
        return returnVal;
    }
}