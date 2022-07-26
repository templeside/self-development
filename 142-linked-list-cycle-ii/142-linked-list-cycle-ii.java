/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
    i would do the iteration. and 
    1. find out the matching point.
    2. starting from the head, move the slow andfast pointer one by one.
    3. if matched, return the node - because it is the starting point of the cycle.
    **/
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast !=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow ==fast) break;
        }
        if(fast==null || fast.next == null)return null;
        
        slow = head;
        while(slow!= fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}