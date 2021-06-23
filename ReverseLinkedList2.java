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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // First get rid of this pesky bastard case
        if (left == right)
            return head;
        
        // Set up all nodes
        ListNode subStart = null;       // node at right
        ListNode subStartPrev = null;   // node before left
        ListNode subEnd = null;         // node at left
        ListNode subEndNext = null;     // node after right
        ListNode curr = head;           // Head of list
        
        // Starting at 1 to keep consistent w/ left and right value convention
        // 1st node is at 1, 3rd node at 3, etc
        // This loop just finds values
        for(int i = 1; i <= right; i++) {
            if (i == left - 1)
                subStartPrev = curr;
            if (i == left)
                subStart = curr;
            if (i == right) {
                subEnd = curr;
                subEndNext = curr.next;
            }
            curr = curr.next;
        }
        
        // Now begin reversing
        ListNode prev = null;
        subEnd.next = null;         // Allows our while loop to terminate nicely
        curr = subStart;
        // While we aren't at the end of the sublist keep swapping and moving
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        // Now set the sub head and sub tail elements in with the original list
        subEnd = prev;
        subStart.next = subEndNext;
        if (subStartPrev != null)     // If we didn't start at head, change left - 1
            subStartPrev.next = subEnd;
        else                          // If we started at head we are done
            head = subEnd;
        
        subStart.next = subEndNext;   // Works even if we end at tail (will be null)
        return head;
        
    }
}
