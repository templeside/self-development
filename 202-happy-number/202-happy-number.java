class Solution {
    
    /**
    n= 19 82 68 100 1
slow          ^
fast                ^

    4 16 37 58 89 145 42 20
      ^
         ^
    
    37 = 9+49 = 58
    58 = 25 + 64 = 89
    89 = 64 + 81 = 145
    145 = 1 + 16 + 25 = 42
    42 = 16+4 = 20
    20 = 4
    
    **/
    public int getNext(int n){
        int sum = 0;
        
        while(n>0){
            int digit = n%10;
            sum += digit *digit;
            n=n/10;
        }
        
        return sum;
    }
    
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        
        while(true){
            slow = getNext(slow);
            fast = getNext(getNext(fast));
            if(slow == fast)
                break;
        }
        return slow == 1;
    }
}