class Solution {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int saved = 0;
        while(left<=right){
            int mid = left+(right-left)/2;
            
            if(((long)mid*mid) <= x){
                saved = mid;
                left = mid+1;
            }
            else
                right = mid-1;
        }
        return saved;
    }
}


/**
4
left  = 0   0
right = 4   1
mid =   2   0
saved = 2   
**/