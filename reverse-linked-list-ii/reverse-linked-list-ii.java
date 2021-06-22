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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head ==null) return null;
        
        ListNode curr = head;
        ListNode prev = null;
        
        while(m>1){
            prev = curr;
            curr = curr.next;
            m--;
            n--;
        }
        ListNode tail = prev;
        ListNode end = curr;
        ListNode ret = null;
        while(n>0){
            ListNode temp = curr.next;
            curr.next = ret;
            ret = curr;
            curr = temp;
            n--;
        }
        if(tail!=null){
            tail.next = ret;
        }else{
            head = ret;
        }
            
        
        end.next = curr;
        return head;
    }
}