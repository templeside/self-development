/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    HashMap<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        if(this.map.containsKey(head))
            return this.map.get(head);
        
        Node newNode = new Node(head.val);
        this.map.put(head, newNode);
        newNode.next = copyRandomList(head.next);
        newNode.random = this.map.get(head.random);
        return newNode;
    }
}