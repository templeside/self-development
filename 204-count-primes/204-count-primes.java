class Solution {
    // can use by brute force, using two for loop. 
    // but can use better way by crossing out the prime number and its multiplication.
    /**
        creating the boolean[]  isPrime = boolean[n];
        
        1 2 3 4 5 6 7 8 9 10
    2         ^   ^   ^    ^
    3                   ^ 
    5                                   25
    7                                   49
    
    time complexity = O(N * sqrt(N))
    */
    
    
    public int countPrimes(int n) {
        
        boolean[] notPrime = new boolean[n];
        
        for(int i=2; i<= (int)Math.sqrt(n);i++){
            if(!notPrime[i]){
                for(int j= i*i; j<n; j+=i){
                    notPrime[j] = true;
                }
            }
        }
        
        int count =0;
        for(int i=2; i<n;i++){
            if(!notPrime[i])
                count++;
        }
        return count;
    }
}