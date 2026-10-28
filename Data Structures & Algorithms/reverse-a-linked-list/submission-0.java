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

 //head = [0,1,2,3]
 //rebuild = [3, 2, 1, 0]


class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;  // 1. save the rest of the list
            curr.next = prev;           // 2. flip this arrow backward
            prev = curr;                // 3. move prev forward
            curr = next;                // 4. move curr forward
        }
        return prev;                    // prev ends on the old last node
    }
}
