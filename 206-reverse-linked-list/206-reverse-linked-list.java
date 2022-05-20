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
    /**
     1->2->3->4->5
prev 1->null
curr 2->3->4->5
Next 2->3->4->5
    **/
        ListNode prev=  null;
        ListNode curr = head;
        
        while(curr !=null){
            ListNode tempNext = curr.next;
            curr.next =prev;
            prev = curr;
            curr = tempNext;
        }
        return prev;
    }
}