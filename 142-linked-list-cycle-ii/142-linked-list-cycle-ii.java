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
          ^
         3204
    slow  ^
    fast  ^
    123
    3/2 = 1
           ^
         123456
    slow   ^
    fast   ^
    1234
    4/2 = 2 after two blocks.
    **/
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast !=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        if(fast ==null || fast.next ==null)return null;
        
        slow = head;
        while(true){
            if(slow == fast)
                return slow;
            slow = slow.next;
            fast = fast.next;
            
        }
        
        // return head;
    }
}