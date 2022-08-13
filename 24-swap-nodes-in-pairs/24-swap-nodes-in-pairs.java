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
    swap it yeah.!
    how???? by my side!
    1-2-3-4-null
    1-2-3-4-5-null
    */
    public ListNode swapPairs(ListNode head) {
        ListNode preHead = new ListNode(-1, head);
        ListNode currNode = head;
        ListNode prevTail = preHead;
        int count = 2;
        while(currNode!=null){
            count --;
            if(count ==0){
                currNode = swap(prevTail, currNode);
                prevTail = currNode;
                count =2;
            }
            currNode = currNode.next;
        }
        return preHead.next;
    }
    
    public ListNode swap(ListNode prevTail, ListNode currNode){
        ListNode prevTailNext = prevTail.next;
        prevTailNext.next = currNode.next;
        currNode.next = prevTailNext;
        prevTail.next = currNode;
        
        
        return prevTailNext; 
    }
}