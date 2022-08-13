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
    recursion is best
    
    recursion(ListNode l1, ListNode l2, int mod):
        curr.val 나오고
        currNode.next = recursion(l1, l2, mod);
        return curr;
    */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return recursion(l1, l2, 0);
    }
    
    public ListNode recursion(ListNode l1, ListNode l2, int mod){
        if(l1 == null && l2 == null){
            if(mod ==0)return null;
            else
                return new ListNode(mod);
        }
        
        int valSum = mod;
        if(l1 !=null){
            valSum += l1.val;
            l1 = l1.next;
        }
        if(l2 !=null){
            valSum += l2.val;
            l2 = l2.next;
        }
        
        ListNode currNode = new ListNode(valSum%10);
        currNode.next = recursion(l1, l2, valSum /10);
        return currNode;
    }
}