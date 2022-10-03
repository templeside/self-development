class Solution {
    /**
    should be matched.
    storing on the stack, and find the character isd valid or not.
    
    1. iterating through the character:
        compare with the stack
        if the char is the matching closure, pop
        if not, add the current opener.
        
        "([)]"
    **/
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<Character>();
        
        int n = s.length();
        
        for(int i=0; i< n; i++){
            char curr = s.charAt(i);
            
            if(curr =='(' || curr =='[' || curr=='{')
                stack.add(curr);
            else{
                if(stack.size ()== 0)return false;
                
                else if((curr ==')' && stack.getLast() =='(') ||
                   (curr ==']' && stack.getLast() =='[') ||
                   (curr =='}' && stack.getLast() =='{'))
                    stack.removeLast();
                else
                    return false;
            }
            // System.out.println(stack);
        }
        
        return stack.size() == 0;
    }
}