class Solution {
    /*
        f(5) = 
        /  \
    f(4) +  f(3)
    /\      /\
f(3) f(2) f(2)f(1)

values - prevent overlap, storing.
    
    */
    
    HashMap<Integer,Integer> storedFib;
    
    public int fib(int n) {
        //hash map to prevent overlap   //f(n), val
        storedFib = new HashMap<>();            
        storedFib.put(0,0);
        storedFib.put(1,1);
        
        return fibFunction(n , storedFib);
    }
    
    public int fibFunction(int n, HashMap<Integer, Integer> storedFib){
        //checker if already stored or not.
        if(storedFib.containsKey(n)){
            return storedFib.get(n);
        }
        
        //if not found the already stored key,
        int val = fib(n-1) + fib(n-2);// O(N^2)
        storedFib.put(n, val);
        return val;
    }
}