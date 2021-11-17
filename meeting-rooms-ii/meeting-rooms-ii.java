class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length ==0)return 0;
        
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();    //saving end time.
        
        q.add(intervals[0][1]);
        for(int i=1; i<intervals.length;i++){
            int[] interval = intervals[i];
            if(q.peek() <= interval[0])
                q.poll();
            q.add(interval[1]);
        }
        return q.size();
    }
}