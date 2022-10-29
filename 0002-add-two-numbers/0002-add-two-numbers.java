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
    trying to add values. those are on reverse order, which means I can add from the one's digit, pass the offest to the next digit.
    i would have offset, and move on.
    */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
            
        return recurse(l1, l2, 0);
    }
    
    public ListNode recurse(ListNode l1, ListNode l2, int offset){
        if(l1 ==null && l2 == null && offset ==0)
            return null;
        int sum = offset;
        if(l1 !=null){
            sum += l1.val;
            l1 = l1.next;
        }
        if(l2!= null){
            sum += l2.val;
            l2 = l2.next;
        }
            
        
        ListNode curr = new ListNode(sum%10);
        curr.next = recurse(l1, l2, sum/10);
        return curr;
    }
}