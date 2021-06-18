/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        for(int i=0;i< n;i++){
            if(knows(candidate,i)) 
                candidate = i;
        }
        if(isHeCelebrity(candidate, n))return candidate;
        return -1;
    }
    private boolean isHeCelebrity(int candidate,int n){
        for(int j=0;j<n;j++){
            if(candidate == j) continue;
            if(knows(candidate, j) || !knows(j,candidate))
                return false;
        }
        return true;
    }
}