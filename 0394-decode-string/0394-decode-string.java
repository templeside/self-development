class Solution {
    /*
    find the digit
        recursion with the matching brackets
            multiply by the digits
            add to the returning value
    */
    public String decodeString(String s) {
        int n = s.length();
        return recursion(s, 0, n-1);
    }
    public String recursion(String s, int startIdx, int endIdx){
        StringBuilder sb = new StringBuilder();
        
        // find the digit
        for(int i=startIdx; i<= endIdx; i++){
            char currChar = s.charAt(i);
            if(Character.isDigit(currChar)){
                int digitEnd = i;
                while(Character.isDigit(s.charAt(digitEnd)))
                    digitEnd++;
                
                //find left
                int newStartIdx = digitEnd;
                //find right
                int newEndIdx = findMatchingEnd(newStartIdx, s);
                
                // System.out.println(" newStartIdx: "+ newStartIdx +" newEndIdx: "+newEndIdx);
                // recursion with the matching brackets
                String decoded = recursion(s, newStartIdx, newEndIdx);
                
                // multiply by the digits
                for(int a=0; a< Integer.valueOf(s.substring(i, digitEnd)); a++){
                    //add to the returning value
                    sb.append(decoded);
                    // System.out.println(sb.toString());
                }
                    
                i = newEndIdx-1;
            }else if(Character.isLetter(currChar)){
                sb.append(currChar);
            }
        }
        return sb.toString();
    }
    
    public int findMatchingEnd(int startIdx, String s){
        Stack<Character> stack =new Stack<>();
        for(int i= startIdx; i< s.length(); i++){
            char currChar = s.charAt(i);
            if(currChar =='[')
                stack.push(currChar);
            else if(currChar ==']'){
                stack.pop();
                if(stack.size() ==0)
                    return i;
            }
        }
        return -1;
    }
}
