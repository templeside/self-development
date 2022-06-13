class Solution {
    /**
Input: intervals = 
[[0,30],[5,10],[15,20]]
                  ^
[  peek]            peek.end> curr.start
     [  curr   ]
stack. 10 30 

comparing with curr save and priorityqueue pointer.

if smaller, remove.

keep the max val.

Output: 2
Time complexity: O(N log N)
space complexity: O(max val)
    **/
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int maxRoom = 0;
        
        for(int[] interval: intervals){
            while(!queue.isEmpty() && queue.peek()<= interval[0])
                queue.poll();
            queue.add((interval[1]));
            maxRoom = Math.max(maxRoom, queue.size());
        }
        return maxRoom;
    }
}