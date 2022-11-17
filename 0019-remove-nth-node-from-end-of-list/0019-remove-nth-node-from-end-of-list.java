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
    recurse it down to the end, and return the level of level. if it matches, then remove the node.
    
    1->2->3->4->5
    2->3->4->5
    3->4->5
    4->5    return 2
    5       return 1
    null
    */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preHead = new ListNode(-1, head);
        recursion(preHead, n);
        
        return preHead.next;
    }
    public int recursion(ListNode curr, int n){
        if(curr == null)return 0;
        
        int level = recursion(curr.next, n);
        if(level == n){
            curr.next = curr.next.next;
        }
        return level+1;
    }
}