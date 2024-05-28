class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int maxDist = 0;
        int last = -1;
        
        for(int i=0; i< n; i++){
            if(seats[i] == 1){
                maxDist = last<0? i: Math.max(maxDist, (i-last)/2);
                last = i;
            }
        }
        return Math.max(maxDist, n-last-1);
    }
}