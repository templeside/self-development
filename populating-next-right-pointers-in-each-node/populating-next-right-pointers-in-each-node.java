/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root ==null )return null;
        Queue<Node> currLevel = new LinkedList<Node>();
        Queue<Node> nextLevel;
        
        currLevel.add(root);
        while(currLevel.size() != 0){
            nextLevel = new LinkedList<Node>();
            int len = currLevel.size();
            
            for(int i=0;i< len; i++){
                Node curr = currLevel.poll();
                // int value = curr.val;
                // int left=0;
                // int right=0;
                // if(curr.left !=null) 
                    // left= curr.left.val;
                // if(curr.right !=null) 
                    // right = curr.right.val;
                if(currLevel.size() !=0)
                    curr.next = currLevel.peek();
                
                if(curr.left !=null)
                    nextLevel.add(curr.left);
                if(curr.right !=null)
                    nextLevel.add(curr.right);
            }
            currLevel = nextLevel;
        }
        return root;
    }
}