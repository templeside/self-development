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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode curr = head;
        int countup = 0;
        
        while(l1 !=null || l2 !=null || countup !=0){
            int l1val = l1 !=null? l1.val: 0;
            int l2val = l2 !=null? l2.val: 0;
            
            int sum = l1val+l2val+countup;
            curr.next = new ListNode(sum%10);
            countup = sum/10;
            curr = curr.next;
            
            if(l1 !=null)
                l1= l1.next;
            if(l2 !=null)
                l2 = l2.next;
        }
        
        
        return head.next;
        
    }
}