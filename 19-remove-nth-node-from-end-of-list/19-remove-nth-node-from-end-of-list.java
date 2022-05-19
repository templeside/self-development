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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temphead = new ListNode(-1, head);
        remove(temphead, n);
        return temphead.next;
    }
    
    public int remove(ListNode head, int n){
        if(head ==null)return 0;
        
        int currLevel = remove(head.next, n) +1;
        
        if(currLevel == n+1){
            if(n ==1) 
                head.next = null;
            else
                head.next = head.next.next;
        }
        return currLevel;
    }
}