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
        PriorityQueue<ListNode> q = new PriorityQueue<>((a,b)-> a.val-b.val);
        
        for(ListNode list : lists){
            while(list !=null){
                ListNode tempNext = list.next;
                list.next = null;
                q.add(list);
                list = tempNext;
            }
            
        }
        
        ListNode preHead = new ListNode();
        ListNode curr = preHead;
        while( !q.isEmpty()){
            ListNode node = q.poll();
            curr.next = node;
            curr = curr.next;
        }
        return preHead.next;
    }
}