class Solution {
    class Node{
        int index;
        String source;
        String target;
        public Node(int i, String s, String t){
            index = i;
            source = s;
            target = t;
        }
    }
    
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        PriorityQueue<Node> que = new PriorityQueue<Node>((a,b)-> a.index - b.index);
        for(int i=0; i<indices.length;i++){
            que.add(new Node( indices[i], sources[i], targets[i]));
        }
        StringBuilder sb = new StringBuilder();
        
        Node node = que.poll();
        int i=0;
        while(node!=null && i<s.length()){
            if(node.index == i){
                if(node.source.equals(s.substring(i, i+node.source.length()))){
                    i += node.source.length();
                    sb.append(node.target);
                    node = que.poll();
                    continue;
                }else{
                    node = que.poll();
                }
            }
            sb.append(s.charAt(i));
            i++;
        }    
        if(i<s.length())
            sb.append(s.substring(i,s.length()));
        
        return sb.toString();
    }
}