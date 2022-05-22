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
    I'll get slow and fast pointer to 
    1. find cycle
    2. lets say the start point of the cycle is 0, and the distance from head to the start point of the cycle is t.
        the point is 
    
    **/
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast !=null && fast.next !=null){
            slow= slow.next;
            fast = fast.next.next;
            
            if(slow==fast)
                break;
        }
        if(fast ==null || fast.next ==null)return null;
        
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
}