class Solution {
    /*
    can't i just find out the way to do the max distance by getting the length of the max length?
    3 - 2
    
    seats = [1,0,0,0,1,0,1]
    alex       ^
    left     ^ 
    right        ^
    
    brute force - 자기가 앉은자리를 기준으로 계속 closest location을 찾으면 된다.
    
    for(int i=0; i< n; i++){
        find the closest by increasing.
    }
    */
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int maxClosest = 0;
        
        for(int i=0; i<n; i++){
            if(seats[i] ==0)
                maxClosest = Math.max(maxClosest, findClosest(seats, i));
        }
        return maxClosest;
    }
    
    /*
    how about the currIdx is left most or right most idx?
    i need to handle that.
    1. when alex is in between the people
    2. when alex is on the edge
    3. when alex is not between the people
    */
    public int findClosest(int[] seats, int currIdx){
        int left = currIdx-1;
        int right = currIdx+1;
        int n = seats.length;
        
        int closest = Integer.MAX_VALUE;
        
        while((left>=0 || right <n) && closest == Integer.MAX_VALUE){
            //left
            if(left>=0) {
                if(seats[left] ==1)
                    closest = Math.min(closest, currIdx-left);
                left --;
            }
            
            if(right<n){
                if(seats[right] ==1)
                    closest = Math.min(closest, right-currIdx);
                right++;
            }
        }
        
        return closest;
    }
}