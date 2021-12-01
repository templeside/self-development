class Solution {
    public double myPow(double x, int n) {
        if(x == 0)return 0;
        int N = n;
        if(N<0){
            x = 1/x;
            N = -N;
        }
        
        return pow(x,N);
    }
    
    
    // 2^5
    // 2^2 * 2^2 * 2
    // x^2 *x^2 *x
    private double pow(double x, int n){
        if (n == 0) return 1;
        
        double temp = pow(x, n/2);
        if(n%2 ==0)
            return temp *temp;
        return temp * temp *x;
    }
}