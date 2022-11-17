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
    2 4 3
    5 6 4
    
    */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1Idx =0, l2Idx = 0;
        int offset = 0;
        
        ListNode preHead = new ListNode();
        ListNode currNode = preHead;
        while(l1 !=null || l2 !=null || offset !=0){
            int sum = offset;
            if(l1 !=null){
                sum += l1.val;
                l1 = l1.next;
            }
                
            if(l2 !=null){
                sum += l2.val;
                l2 = l2.next;
            }
                
            
            currNode.next = new ListNode(sum%10);
            offset = sum/10;
            currNode = currNode.next;
        }
        return preHead.next;
    }
}