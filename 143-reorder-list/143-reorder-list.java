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
/**
1. cut in half(using slow, fast pointer)
2. in there, reverse the after half.
3. merge the list.
**/
class Solution {
    /**
    1->2->3->4
slow      ^
fast            ^
    1->2->3->4->5
slow      ^
fast            ^
    **/
    public ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast !=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head !=null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        ListNode mid = getMid(head);
        ListNode reversed = reverse(mid);
        
        ListNode curr = head;
        while(curr.next !=null && curr.next !=mid){
            ListNode tempCurr = curr.next;
            ListNode tempReversed = reversed.next;
            curr.next= reversed;
            curr= curr.next;
            
            curr.next= tempCurr;
            curr = curr.next;
            
            reversed = tempReversed;
        }
        if(curr !=reversed)
            curr.next = reversed;
    }
}