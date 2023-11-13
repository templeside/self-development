class Solution {
    /*
            f(5)
            /\
        f(4) f(3)
        /\      /\
    f(3)f(2) f(2)f(1)
    /\    /\
f(2)f(1) f(1)f(0)

hashMap<n, val> 

        f(0) f(1) f(2) f(3) f(4)
    fib                      ^
prev                    ^
prevprev            ^
    */
    public int fib(int n) {
        if(n<=1)return n;
        int prevVal = 1;
        int prevprevVal = 0;
        
        for(int currFib= 2; currFib<= n; currFib++){
            int sum = prevVal + prevprevVal;    // currFibVal.
            
            prevprevVal = prevVal;
            prevVal = sum;
        }
        return prevVal;
    }
}