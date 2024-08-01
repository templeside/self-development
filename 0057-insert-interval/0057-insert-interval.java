class Solution {
    /*
    use priority queue to sort the starting date of interval.
    then, compare the initial date and if found the 
    
    [[1,3],[6,9]]
      ^
    
    comparator is starting interval
    
    if starting newInterval is bigger than end of the interval 
        merge:
            compare starting interval
            compare ending interval
    else
        continue
    new interval - [2,5]
    */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Queue<int[]> queue =new PriorityQueue<>((a,b)-> a[0]-b[0]);

        for(int[] interval: intervals){
            queue.add(interval);
        }
        queue.add(newInterval);
        
        ArrayList<int[]> intervalList = new ArrayList<>();
        int[] prev = null;
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            
            if(prev == null || prev[1]< curr[0]){   // no connection, interval
                intervalList.add(curr);
                prev = curr;    
            }else   // have interval{
                intervalList.get(intervalList.size()-1)[1] = Math.max(curr[1], prev[1]);
        }
        
        int[][] returnVal = new int[intervalList.size()][2];
        for(int i=0; i< returnVal.length; i++){
            returnVal[i] = intervalList.get(i);
        }
        return returnVal;
    }
}