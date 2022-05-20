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
         1->2->3->4
    prev 2->1
    curr 3->4
    next 3->4
    **/
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr =head;
        
        while(curr !=null){
            ListNode tempNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNext;
        }
        return prev;
    }
}