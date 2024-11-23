class Solution {
    /*
    split by /
    
    */
    public String simplifyPath(String path) {
        String[] sArr = path.split("/");
        
        Stack<String> queue = new Stack();
        for(String s: sArr){
            if(s.equals(""))
                continue;
            if(s.equals("."))
                continue;
            else if(s.equals("..")){
                if(!queue.isEmpty())
                    queue.pop();
                continue;
            }
            queue.push(s);
        }
        StringBuilder sb = new StringBuilder();
        
        while(!queue.isEmpty()){
            sb.insert(0, queue.pop());
            sb.insert(0, "/");
        }
        return sb.isEmpty()? "/": sb.toString();
    }
}