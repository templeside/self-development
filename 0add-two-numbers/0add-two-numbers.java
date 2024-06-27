/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /*
    iterating with two pointers.
    l1, l2, offset
    while(l1 != null || l2 !=null)
    if offset !=0
    */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // iterating with two pointers.
        // l1, l2, offset
        int offset = 0;                
        ListNode prehead = new ListNode();
        ListNode tail = prehead;

        // while(l1 != null || l2 !=null)
        while(l1 !=null || l2 !=null || offset !=0){
            if(l1!=null){
                offset = offset+ l1.val;
                l1 = l1.next;
            }
                
            if(l2 !=null){
                offset = offset +l2.val;
                l2 = l2.next;
            }
                
            
            //generate new node
            ListNode newNode = new ListNode(offset%10);
            tail.next = newNode;
            tail = tail.next;
            
            //update new offset
            offset = offset/10;
        }
            
        return prehead.next;
    }
}