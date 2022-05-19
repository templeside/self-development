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
            12345
    prev    ^
    curr     ^
    2 1
    **/
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr !=null){
            ListNode nexttemp = curr.next;
            curr.next= prev;
            prev = curr;
            curr = nexttemp;
        }
        
        return prev;
    }
}