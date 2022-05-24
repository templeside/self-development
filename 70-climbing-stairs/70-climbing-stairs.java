class Solution {
    /**
    if n== 2
            ^
goal f(1)  f(2)   f(3)   
     f(0)  f(1)   f(2)
     f(-1) f(0)   f(1)
            2       3
f(i) = f(i-1) + f(i-2)
    **/
    public int climbStairs(int n) {
        if(n==0)return 0;
        if(n==1)return 1;
        if(n==2)return 2;
        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 2;
        for(int i=3;i<=n;i++){
            memo[i]=  memo[i-1]+ memo[i-2];
        }
        return memo[n];
    }
}