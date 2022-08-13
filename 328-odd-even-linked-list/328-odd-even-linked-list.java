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
    public ListNode oddEvenList(ListNode head) {
        ListNode oddList = new ListNode(-1);
        ListNode evenList = new ListNode(-1);
        
        ListNode oddTail = oddList;
        ListNode evenTail = evenList;
        
        ListNode currNode = head;
        while(currNode !=null ){
            // when node is odd
            ListNode tempNext = currNode.next;

            oddTail.next = currNode;
            oddTail = oddTail.next;
            oddTail.next = null;
            currNode = tempNext;
            
            //when node is even
            if( currNode !=null){
                tempNext = currNode.next;
                
                evenTail.next = currNode;
                evenTail = evenTail.next;
                evenTail.next = null;
                currNode = tempNext;
            }
        }
        
        if(oddList == oddTail)return null;
        oddTail.next = evenList.next;
        return oddList.next;
    }
}