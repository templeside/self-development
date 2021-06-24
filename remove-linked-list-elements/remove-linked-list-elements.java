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
    public ListNode removeElements(ListNode head, int val) {
        
        ListNode preNode = new ListNode();
        preNode.next = head;
        ListNode curr = preNode;
        
        while(curr.next !=null){
            int currNum = curr.val;
            int currNext = curr.next.val;
            if(curr.next.val == val){
                curr.next = curr.next.next;
                continue;
            }
            curr = curr.next;
        }
        return preNode.next;
    }
}