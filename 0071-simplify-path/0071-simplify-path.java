class Solution {
    public String simplifyPath(String path) {
        String[] sArr = path.split("/");
        ArrayDeque<String> queue= new ArrayDeque<>();
        
        for(String s: sArr){
            if(s.isEmpty() ||s.equals("."))
                continue;
            else if(s.equals("..")){
                if(!queue.isEmpty()) queue.pop();
            }
            else
                queue.push(s);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            sb.insert(0, queue.pop());
            sb.insert(0, "/");
        }
        return sb.length() ==0? "/": sb.toString();
    }
}