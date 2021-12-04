/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        // 1. when head ==null
        
        if(head ==null){
            Node newNode = new Node(insertVal);
            newNode.next = newNode;
            return newNode;
        }
        
        // 2. when head[1,2,3,4] inserval out of range[5 or -1]
        // 3. whe nhead[1,2,3,4] inserval is 3.5 
        // prevNode, currNode
        
        Node prevNode = head;
        Node currNode = head.next;
        boolean inserted = false;
        
        do{
            System.out.println(prevNode.val +" "+ currNode.val);
            if(prevNode.val<= insertVal && insertVal<= currNode.val){
                Node newNode = new Node(insertVal);
                newNode.next = currNode;
                prevNode.next = newNode;
                inserted = true;
                return head;
            }else if(prevNode.val> currNode.val){
                if( prevNode.val <= insertVal || insertVal <=currNode.val ){
                    Node newNode = new Node(insertVal);
                    newNode.next = currNode;
                    prevNode.next = newNode;
                    inserted = true;
                    return head;
                }
                }
            
            prevNode = currNode;
            currNode = currNode.next;
        }while(prevNode != head);
        
        prevNode.next = new Node(insertVal, currNode);
        return head;
    }
}