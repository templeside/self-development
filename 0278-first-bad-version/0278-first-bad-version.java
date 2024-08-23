/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

/*            |
        1 2 3 4 5 
left          ^
right           ^
mid           ^
        |
        1 2 3 
left    ^
right       ^
mid       ^
*/
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right =n;
        int first = n;
        while(left<= right){
            int mid = left+(right-left)/2;
            if(isBadVersion(mid)){
                right = mid-1;
                first = mid;
            }else
                left = mid+1;
                
        }
        return first;
    }
}