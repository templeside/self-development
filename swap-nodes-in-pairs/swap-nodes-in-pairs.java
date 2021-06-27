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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;    //edge case
        
        ListNode preHead = new ListNode();
        preHead.next = head;
        
        ListNode tempNexts = head.next.next;        //원래 0 1 2
        ListNode first = head;                      // 1
        ListNode second = head.next;                // 2
        first.next = null;
        second.next = null;
        
        preHead.next = second;                      // 0 2
        second.next = first;                        // 0 2 1
        first.next = swapPairs(tempNexts);    // 0 2 1 ~~~
        return preHead.next;
    }
}