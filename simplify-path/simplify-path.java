class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> word = new Stack<>();
        for(String s : arr){
            if(s.equals(""))
                continue;
            else if(s.equals("."))
                continue;
            else if(s.equals("..")){
                if(!word.isEmpty())
                    word.pop();
            }
                
            else
                word.push(s);
        }
        
        if(word.isEmpty())
            return "/";
        
        StringBuilder sb = new StringBuilder();
        while(!word.isEmpty()){
            
            sb.insert(0,word.pop());
            sb.insert(0,'/');
        }
        
        return sb.toString();
    }
}