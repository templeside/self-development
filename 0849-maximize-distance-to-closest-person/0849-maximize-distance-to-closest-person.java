class Solution {
    /*
    case difference - two cases:
        edge
        between
    no people from start
    [0 .... 1]
    dist = window
    
    in between
    [...1.....1...]
    dist = window/2
    
    no people from end
    [..... 0]       [1,0,0,0] = 3 
    window
    */
    public int maxDistToClosest(int[] seats) {
        int maxDist = 0;
        
        //from start
        int i=0;
        while(seats[i] !=1){
            i++;
        }
        maxDist = Math.max(maxDist, i);
        
        //between [1,0,0,0,1] window = 5-1/2 = 2
        //between [1,0,0,1] window = 4-1/2 = 1
        int prev = i;
        for(int curr = i+1; curr< seats.length; curr++){
            if(seats[curr] == 1){
                int windowSize = curr-prev+1;
                int currDist = (windowSize-1)/2;
                maxDist = Math.max(maxDist, currDist);
                prev = curr;
            }
        }
        
        //from end
        int j=seats.length-1;
        while(seats[j] !=1){
            j--;
        }
        maxDist = Math.max(maxDist, seats.length-1-j);
        return maxDist;
    }
}