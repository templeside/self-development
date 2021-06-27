class Solution {
    public String removeDuplicates(String s, int k) {
        // <{char, count of char}>. because char 
        Stack<int[]> main = new Stack<>();
        
        for(char c: s.toCharArray()){
            if( !main.isEmpty() && main.peek()[0] ==c){ // if main is empty, or c is same
                main.peek()[1] ++;
            }else
                main.push(new int[]{c,1});
            
            if(main.peek()[1] ==k)
                main.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!main.isEmpty()){
            int[] top = main.pop();
            
            while(top[1]-->0)
                sb.append((char) top[0]);
        }
        return sb.reverse().toString();
    }
}