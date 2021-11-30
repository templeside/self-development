class Solution {
    public String simplifyPath(String path) {
        ArrayDeque<String> q = new ArrayDeque<>();
        String[] paths = path.split("/");
        
        for(String s: paths){
            if(s.equals(""))
                continue;
            else if(s.equals("..")){
                if(q.size() ==0) continue;
                else q.pop();
            }
            else if(s.equals("."))
                continue;
            else
                q.push(s);
        }
        
        StringBuilder sb = new StringBuilder();
        while(q.size() !=0){
            sb.insert(0, q.poll());
            sb.insert(0, "/");
        }
        return sb.length() == 0? "/" : sb.toString();
    }
}