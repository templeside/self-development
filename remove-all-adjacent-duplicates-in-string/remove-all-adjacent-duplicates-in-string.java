class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> store= new Stack<>();
        for(int i=0; i<s.length();i++){
            char curr = s.charAt(i);
            if(store.size()==0)
                store.push(curr);
            else if(store.peek() == curr){
                while(!store.isEmpty() &&store.peek() == curr)
                    store.pop();
            }else
                store.push(curr);
        }
        
        String ans ="";
        while(store.size()!=0)
            ans  = store.pop()+ans;
        return ans;
    }
}