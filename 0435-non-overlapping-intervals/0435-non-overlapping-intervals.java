class Solution {
    /*
    똑같은 이야기 인데 
    what is beneficiairy 한건지 어떻게 알지????
    backtracking 해야 하는 건가????
    minimum overlapping을 어떻게 optimum 한 건지 알지????

    intervals 하나씩 추가 해 가며 알아야 겠다....?
    minimum - how can we detect that?????
    
    end time가지고 체크한다.
    */
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[1]-b[1]);      // 끝을 가지고 비교
        int count = 0;
        int k = Integer.MIN_VALUE; // most recent interval we kept

        for(int[] interval: intervals){
            int x = interval[0];
            int y = interval[1];

            if(x>= k ){     //x가 k interval 밖에 있을 때. end time이 제일 작으니까 가능.
                k = y;
            }
            else{
                count ++;
            }
        }
        return count;
    }
}