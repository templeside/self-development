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
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> map = new ArrayList<>();
        while (head != null){
            map.add(head.val);
            head = head.next;
        }
        
        for(int i=0;i<map.size()/2;i++){
            if(map.get(i) != map.get(map.size()-1-i))
               return false;
        }
        return true;
    }
}