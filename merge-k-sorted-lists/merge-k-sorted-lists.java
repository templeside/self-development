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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>((a,b)->(a.val-b.val));
        
        for(ListNode list: lists){
            if(list !=null)
                q.add(list);
        }
        
        ListNode head = new ListNode();
        ListNode curr = head;
        while(!q.isEmpty()){
            curr.next = q.poll();
            curr = curr.next;
            if(curr.next !=null)        //adding the next node on to queue.
                q.add(curr.next);
        }
        return head.next;
        
    }
}