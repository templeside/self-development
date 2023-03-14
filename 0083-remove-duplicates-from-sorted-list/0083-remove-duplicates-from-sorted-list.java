/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 chekcing the next node, and if it is having same value, skip the next value.
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode returnHead = head;
        while(head !=null && head.next !=null){
            if(head.val == head.next.val){
                head.next = head.next.next;
                continue;
            }
                
            
            head = head.next;
        }
        return returnHead;
    }
}