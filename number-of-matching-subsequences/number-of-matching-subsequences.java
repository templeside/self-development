class Solution {
    class Node{
        public int idx;
        public String str;
        public Node(String s, int id){
            idx = id;
            str = s;
        }
    }
    
    public int numMatchingSubseq(String s, String[] words) {
        int count=0;
        
        ArrayList<Node>[] heads = new ArrayList[26];
        for(int i=0; i< 26;i++){
            heads[i] = new ArrayList<>();
        }
        
        for(String word: words){
            Node curr = new Node(word,0);
            heads[word.charAt(0)-'a'].add(curr);
        }
        
        for(char c: s.toCharArray()){
            ArrayList<Node> old_bucket = heads[c-'a'];
            heads[c-'a'] = new ArrayList<Node>();

            for(Node n : old_bucket){
                String word = n.str;
                int id = n.idx;
                n.idx ++;
                if(n.idx == n.str.length())
                    count ++;
                else{
                    heads[n.str.charAt(n.idx)-'a'].add(n);
                }
            }
        }
        return count;
    }
}