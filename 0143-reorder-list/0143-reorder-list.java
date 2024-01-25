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
    /*
    1. find half
    2. reverse right half
    3. merge the order.
    
    pre->1->2->3->4->null
fast              ^
slow        ^
    pre->1->2->3->4->5->null
fast                     ^
slow           ^

slow.next = reversed.

merge
    */
    public void reorderList(ListNode head) {
        if(head ==null)return;
        
        ListNode preHead= new ListNode(0, head);
        // find middle
        ListNode slow = preHead;
        ListNode fast = preHead;
        
        while(fast !=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode right = slow.next;
        slow.next = null;
        // reverse right
        ListNode reversed = reverse(right);
        
        // merge order
        ListNode iterator = preHead;
        
        while(head !=null){
            iterator.next = head;
            head = head.next;
            iterator = iterator.next;
            iterator.next = null;
            
            if(reversed ==null)continue;
            iterator.next = reversed;
            reversed = reversed.next;
            iterator = iterator.next;
            iterator.next = null;
        }        
        return;
    }
    
    public static ListNode reverse(ListNode curr){
        ListNode next = null;
        ListNode reversed = null;
        while(curr !=null){
            next = curr.next;
            curr.next = reversed;
            reversed = curr;
            curr = next;
        }
        return reversed;
    }
}