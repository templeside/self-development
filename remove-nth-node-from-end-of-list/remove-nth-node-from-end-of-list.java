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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preHead = new ListNode(0,head);
        int len = checkLength(head);
        return helper(preHead, len-n).next;
    }
    
    public ListNode helper(ListNode root, int index){
        
        if(index ==0){
            if(root == null)
                return null;
            else if(root.next ==null)
                return root;
            else
                root.next = root.next.next;
        }
            
        else
            root.next = helper(root.next, index-1);
        return root;
    }
    
    public int checkLength(ListNode root){
        if( root ==null)return 0;
        return checkLength(root.next)+1;
    }
}