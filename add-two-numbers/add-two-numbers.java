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
        ListNode curr = preNode;
        
        int addNum = 0;
        while(l1 !=null || l2 !=null || addNum ==1 ){
            int sum = addNum;
            if(l1 !=null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 !=null){
                sum += l2.val;
                l2 = l2.next;
            }
            
            addNum = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
                
        }
        return preNode.next;
    }
}