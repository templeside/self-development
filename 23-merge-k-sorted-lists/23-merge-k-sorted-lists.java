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
    priorityqueue makes it easier to order the linkedlists.
    1->4->5,
     ^
    
    1->3->4,
    ^
    
    2->6
    ^

    1 -
    
    from the priorityQueue-> get always the minimum value
        if the list next is still available, go next
    */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b)-> a.val-b.val);
        ListNode preHead = new ListNode();
        ListNode prev=  preHead;
        
        for(ListNode list: lists){
            if(list !=null)
                queue.add(list);
        }
        
        while(queue.size()>0){
            ListNode currNode = queue.poll();
            if(currNode.next !=null)
                queue.add(currNode.next);
            currNode.next= null;
            
            prev.next = currNode;
            prev = currNode;
        }
        return preHead.next;
    }
}