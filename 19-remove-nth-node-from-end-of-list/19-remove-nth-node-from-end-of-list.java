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
    /**
     null-1-2-3-4-5, n=2
slow          ^
fast                ^
    **/
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tempHead = new ListNode(-1, head);
        ListNode slow = tempHead;
        ListNode fast = tempHead;
        
        for(int i=0; i< n+1; i++){
            fast = fast.next;
        }
        
        while(fast !=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        
        return tempHead.next;
    }
}