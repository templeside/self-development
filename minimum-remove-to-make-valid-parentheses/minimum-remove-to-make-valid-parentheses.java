class Solution {
    public String minRemoveToMakeValid(String s) {
        int openCount = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i< s.length();i++){
            char c= s.charAt(i);
            if(c== '('){
                sb.append(c);
                openCount++;
            }else if(c ==')'){
                if(openCount >0){
                    openCount --;
                    sb.append(c);
                }
            }else
                sb.append(c);
        }
        
        StringBuilder result = new StringBuilder();
        for(int i= sb.length()-1 ;i>=0; i--){
            if(sb.charAt(i) == '(' && openCount -- >0 )
                continue;
            result.append(sb.charAt(i));
        }
        return result.reverse().toString();
            
    }
}

