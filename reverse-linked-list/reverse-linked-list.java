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
    public ListNode reverseList(ListNode head) {
        ListNode preHead = new ListNode();
        while( head !=null){
            ListNode curr = head;
            head = head.next;
            
            curr.next  = preHead.next;
            preHead.next = curr;
        }
        return preHead.next;
    }
}