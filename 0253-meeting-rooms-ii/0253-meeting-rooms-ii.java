class Solution {
    /*
    trying to get as less as possible numbers of meeting rooms
    
Input: intervals = [[0,30],[5,10],[15,20]]
    [0              30]
        [5,10]  [15,20]
        
Output: 2
    intervals should be sorted
    we do have priorityqueue based on end time
    
    keep track of stack size.
    */
    public int minMeetingRooms(int[][] intervals) {
    //     intervals should be sorted
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
    //     we do have priorityqueue based on end time
        PriorityQueue<int[]> queue =new PriorityQueue<>((a,b)-> a[1]-b[1]);
        int maxNum = 0;
        
        for(int[] interval: intervals){
            while(!queue.isEmpty() && queue.peek()[1] <= interval[0]){
                queue.poll();
            }
            queue.add(interval);
            maxNum = Math.max(maxNum, queue.size());
        }

    //     keep track of stack size.
        return maxNum;
    }
}