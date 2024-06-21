class Solution {
    //in the middle
    //most left
    //most right
    public int maxDistToClosest(int[] seats) {
        if(seats == null || seats.length ==0)return 0;
        
        int n = seats.length;
        int maxDist = 0;
        int emptyCount = 0;
        
        // in the middle, (val+1)/2
        for(int i=0; i< n; i++){
            if(seats[i] == 1)
                emptyCount=0;
            else{
                emptyCount++;
                maxDist = Math.max(maxDist, (emptyCount+1)/2);
            }
        }
        
        //most left
        for(int i=0; i<n; i++){
            if(seats[i] ==1){
                maxDist = Math.max(maxDist, i);
                break;
            }
        }
        
        //most right
        for(int i=n-1; i>=0; i--){
            if(seats[i] ==1){
                maxDist = Math.max(maxDist, n-i-1);
                break;
            }
        }
        return maxDist;
    }
}