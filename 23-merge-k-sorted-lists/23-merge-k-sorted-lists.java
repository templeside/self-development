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
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b)-> a.val- b.val);
        
        ListNode preHead = new ListNode(-1);
        for(ListNode list: lists)
            if(list !=null)
                queue.add(list);
        
        ListNode prev = preHead;

        // need to have node iterator
        while(queue.size()>0){
            ListNode curr = queue.poll();
            prev.next = curr;
            
            if(curr.next!=null){
                curr = curr.next;
                queue.add(curr);
            }
            prev = prev.next;
        }
        prev.next= null;
        return preHead.next;
    }
}