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
/**
Input: lists = [[1,4,5],[1,3,4],[2,6]]
[1,4,5]
 ^
[1,3,4]
 ^
[2,6]
 ^

Output: [1,1,2,3,4,4,5,6]
**/
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode preHead = new ListNode(-1);
        ListNode prev=  preHead;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b)-> a.val - b.val);
        for(ListNode list: lists){
            if(list !=null)
                queue.add(list);
        }
            
        
        while(queue.size()>0){
            ListNode curr = queue.poll();
            prev.next = curr;
            prev = curr;
            
            curr = curr.next;
            if(curr!=null)
                queue.add(curr);
        }
        return preHead.next;
    }
}