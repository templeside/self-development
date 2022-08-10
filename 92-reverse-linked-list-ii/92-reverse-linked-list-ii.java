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
    having prev node to connect the reversed link, and iterate by right side too.
    on there, having the next head and stop.
    1-> 2-> 3-> 4-> 5    [2,4]
    
    curr 4-> 3-> 2-> null
    prev 4-> 3-> 2-> null
    tempNext 5
    
    do reverse 3 time. 
    
    left and right are the credits
        [3,5]
curr     ^
prevTail ^
1
2
    **/
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right)return head;
        ListNode prevHead=  new ListNode();
        prevHead.next = head;
        
        ListNode curr = prevHead;

        for(int i=0; i< left-1 ; i++){
            curr = curr.next;
        }
        
        ListNode prevTail = curr;
        curr = curr.next;
        
        ListNode reversed = reverse(curr, right-left+1);
        prevTail.next = reversed;
        
        return prevHead.next;
    }
    public ListNode reverse(ListNode head, int reverseNumber){
        ListNode curr = head;
        ListNode prev=  null;
        ListNode tempNext = null;
        for(int i=0; i< reverseNumber; i++){
            tempNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNext;
        }
        head.next =tempNext;
        return prev;
    }
}