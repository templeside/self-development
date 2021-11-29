class Solution {
    public int minAddToMakeValid(String s) {
        ArrayDeque<Character> q = new ArrayDeque<>();
        
        int count=0;
        
        for(char c: s.toCharArray()){
            if(c=='(')
                q.push(c);
            else{
                if(q.size()==0 || q.peek() ==')')
                    q.push(c);
                else
                    q.pop();
            }
                
        }
        return q.size();
    }
}