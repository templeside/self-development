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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode preNode = new ListNode();
        ListNode currNode = preNode;
        int offset = 0;
        while(l1 !=null || l2 != null || offset !=0){
            int currNum = offset;
            
            if(l1 !=null){
                currNum += l1.val;
                l1 = l1.next;
            }
                
            if(l2 !=null){
                currNum+= l2.val;
                l2 = l2.next;
            }
                
            
            currNode.next = new ListNode(currNum%10);
            currNode = currNode.next;
            offset = currNum/10;
            
        }
        return preNode.next;
        
    }
}