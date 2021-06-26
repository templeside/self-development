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
    public ListNode partition(ListNode head, int x) {
        ListNode beforeXHead = new ListNode();
        ListNode beforeXTail = beforeXHead;
        ListNode afterXHead = new ListNode();
        ListNode afterXTail = afterXHead;
        
        ListNode curr = head;
        while(curr !=null){
            ListNode tempNext = curr.next;
            curr.next = null;
            
            if(curr.val <x){
                beforeXTail.next = curr;
                beforeXTail = beforeXTail.next;
            }else{
                afterXTail.next = curr;
                afterXTail = afterXTail.next;
            }
            curr = tempNext;
        }
        beforeXTail.next = afterXHead.next;
        return beforeXHead.next;
    }
}