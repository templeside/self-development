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
               | 
            12345
            123 5
    left      ^  
    right        ^
    n=2
    **/
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode left = dummy;
        ListNode right = dummy;
        
        for(int i=0; i<= n; i++)
            right = right.next;
        
        while(right!=null){
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }
    
}