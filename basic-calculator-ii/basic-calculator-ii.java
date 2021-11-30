class Solution {
    public int calculate(String s) {
        // 1. find digits and operations
        // 2. 
        if(s==null || s.isEmpty()) return 0;
        
        ArrayDeque<Integer> q =new ArrayDeque<Integer>();
        int currNum = 0;
        char operation = '+';
        
        for(int i=0; i< s.length();i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                currNum = currNum*10+ c-'0';
            }
            if(!Character.isDigit(c) && c !=' ' || i==s.length()-1){
                if(operation=='+')
                    q.push(currNum);
                else if(operation=='-')
                    q.push(-currNum);
                else if(operation== '/'){
                    int prevNum = q.pop();
                    q.push(prevNum/ currNum);
                }else if(operation== '*'){
                    int prevNum = q.pop();
                    q.push(prevNum*currNum);
                }
                operation = c;
                currNum = 0;

            }
            
        }
        int ans =0;
        while(q.size()>0){
            ans += q.poll();
        }
        return ans;
    }
    
}