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
    public ListNode reverseEvenLengthGroups(ListNode head) {
		ListNode prev = head;
		ListNode node, reverse, currNext, curr, prevNext = null;
		int groupLen = 2;
		int numNodes = 0;
		while(prev.next!= null)
		{
			node = prev;
			numNodes = 0;
			for (int i = 0; i < groupLen; i ++)
			{
				if(node.next == null)
                    break;
				numNodes += 1;
				node=node.next;
			}

			if(numNodes % 2 != 0) {
			   prev = node; 
			} else {
				reverse = node.next;
				curr = prev.next;
                for(int j=0; j < numNodes;j++){
                    currNext = curr.next;
				    curr.next = reverse;
				    reverse = curr;
				    curr = currNext;
                }
                prevNext = prev.next;
				prev.next = node;
			    prev = prevNext;
			}
			groupLen += 1;
		}
	    return head;
	}
}