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
    public boolean hasCycle(ListNode head) {
        //2 listNodes
            //fast-track: 2 nodes at a time
            //slow-track: 1 node

        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && slow != null) {
            fast = fast.next;
            if(fast == null || slow == null) return false;
            fast = fast.next;
            slow = slow.next;
            if(fast == null || slow == null) return false;
            if(fast.equals(slow)) return true;
        }
        return false;
    }
}
