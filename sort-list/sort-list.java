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
    public ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> q = new PriorityQueue<>((a,b) -> a.val-b.val);
        while( head !=null ){
            ListNode tempHead = head.next;
            head.next = null;
            q.add(head);
            head = tempHead;
        }
        
        ListNode preNode = new ListNode();
        ListNode curr = preNode;
        while(!q.isEmpty()){
            curr.next = q.poll();
            curr = curr.next;
        }
        return preNode.next;
    }
}