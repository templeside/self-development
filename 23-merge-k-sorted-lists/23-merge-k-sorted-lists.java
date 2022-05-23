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
        PriorityQueue<ListNode> sorted = new PriorityQueue<>((a,b)->{
            return a.val-b.val;
        });
        
        for(ListNode list: lists){
            while(list !=null){
                sorted.add(list);
                list = list.next;
            }
        }
        ListNode ans = sorted.poll();
        ListNode curr = ans;
        while(!sorted.isEmpty()){
            ListNode nextNode =  sorted.poll();
            nextNode.next =null;
            curr.next = nextNode;
            
            curr = curr.next;
            
        }
        return ans;
    }
}