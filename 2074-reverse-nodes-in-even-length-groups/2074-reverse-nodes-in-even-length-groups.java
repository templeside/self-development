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
    prev - prev notifier
    node - iterator
    reverse - reversed connecting lines.
    
    */
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode prev = head;
        ListNode node, prevNext = null;      // for connecting groups
        ListNode curr, currNext, reversed  = null;   // for reversing
        int groupLen = 2;
        int numNodes = 0;
        
        while(prev.next !=null){
            node = prev;
            numNodes = 0;
            for(int i=0; i< groupLen; i++){
                if(node.next == null)
                    break;
                numNodes +=1;
                node = node.next;
            }
            //checking even or not.
            if(numNodes %2 !=0){
                prev = node;
            }else{
                //if even length, reverse
                reversed = node.next;
                curr = prev.next;

                for(int j=0; j<numNodes; j++){
                    currNext = curr.next;       // currNext = curr.nex
                    curr.next = reversed;       // curr.next = reversed
                    reversed = curr;            
                    curr = currNext;
                }     
                                        //                        prev |
                prevNext = prev.next;   //reversed tail.   orig= prev->1->2->3   reversed= prev 3->2->1
                prev.next = node;       //connecting with reversed node.  prev->3->2->1
                prev=prevNext;          //setting new prev to 1.   ...->3->2->1
                                        //                           new prev |
            }
            groupLen +=1;
        }
        return head;
	}
}