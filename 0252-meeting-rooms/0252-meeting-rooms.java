class Solution {
    /*
    
    */
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length ==0)
            return true;
        Arrays.sort(intervals, (a,b)-> a[1]-b[1]);
        // for(int[] interval: intervals){
        //     System.out.println(interval[0] +" "+ interval[1]);
        // }
        int[] prevInterval = intervals[0];
        for(int i=1; i<intervals.length; i++){
            int[] currInterval = intervals[i];
            // System.out.println(interval[0] +" "+ interval[1]);
            if(prevInterval[1] > currInterval[0])
                return false;
            prevInterval = currInterval;
        }
        return true;
    }
}