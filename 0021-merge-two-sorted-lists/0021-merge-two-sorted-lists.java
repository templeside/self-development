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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode(-1);
        ListNode currNode = preHead;
        while(list1 !=null && list2 !=null){
            if(list1.val>list2.val){
                currNode.next = list2;
                list2 = list2.next;
                currNode = currNode.next;
                currNode.next = null;
            }else{
                currNode.next = list1;
                list1 = list1.next;
                currNode = currNode.next;
                currNode.next = null;
            }
        }
        if(list1!=null){
            currNode.next = list1;
        }else{
            currNode.next = list2;
        }
        
        return preHead.next;
    }
}