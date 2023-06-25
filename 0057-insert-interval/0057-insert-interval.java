class Solution {
    /*
    we are merging the intervals as much as we couuld.
    ordered by start.
    
    1. adding all the intervals - LinkedList
    2. sort the intervals - Arrays.sort
    3. merge the sorted intervals if overlapped
        [[1,3],[2,5], [6,9]]
iterator   ^
checking with the previous interval
if prev.end >= curr.start 
    merge: prev.end = curr.end;
else
    add new interval
    
    */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        PriorityQueue<int[]> newQueue = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        for(int[] interval: intervals){
            newQueue.add(interval);
        }
        
        newQueue.add(newInterval);
        
        int[] prev=  null;
        LinkedList<int[]> newInterv = new LinkedList<>();
        
        
        while(!newQueue.isEmpty()){
            int[] currInterval = newQueue.poll();
            
            if(prev == null || prev[1] < currInterval[0]){      // no interval
                newInterv.add(currInterval);
                prev = currInterval;
            }else{                                              // interval
                newInterv.get(newInterv.size()-1)[1] = Math.max(currInterval[1], prev[1]);
                
            }
        }
        
        // for(int i=0; i<newInterv.size();i++){
        //     System.out.println(newInterv.get(i)[0]+" "+newInterv.get(i)[1]);
        // }
        
        int[][] returnInterval = new int[newInterv.size()][2];
        for(int i=0; i< newInterv.size(); i++){
            returnInterval[i] = newInterv.get(i);
        }
        
        return returnInterval;
    }
}