/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        HashSet<Node> set= new HashSet<>();
        
        while(p !=null || q !=null){
            if(p !=null){
                if(set.contains(p))
                    return p;                
                set.add(p);
                p = p.parent;
            }
            
            if(q!= null){
                if(set.contains(q))
                    return q;

                set.add(q);
                q= q.parent;
                
            }            
            
        }
        return null;
    }
}