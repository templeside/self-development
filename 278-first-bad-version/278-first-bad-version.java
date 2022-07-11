/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    /**
    arr = [1,2,3,4,5]
    arr = [f,f,f,t,t]
    left         ^
    right          ^
    mid          ^
    
    if(mid != true)
        left = mid+1;
    else
        leftMost = mid
        right=  mid-1;
    
    find the most right true.
    **/
    public int firstBadVersion(int n) {
        int left=1, right = n;
        int leftMost = n;
        while(left<= right){
            int mid = left+(right-left)/2;
            
            if(isBadVersion(mid)){
                leftMost = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return leftMost;
    }
}