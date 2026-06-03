/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        // 1. Set up the dummy node to point to the head
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        // 'prev' will always sit right before the pair we are swapping
        ListNode prev = dummy;
        
        // Loop as long as there is a PAIR of nodes left to swap
        while (prev.next != null && prev.next.next != null) {
            // Identify the two nodes to be swapped
            ListNode first = prev.next;
            ListNode second = prev.next.next;
            
            // Step 1: Connect the first node to the rest of the list
            first.next = second.next;
            
            // Step 2: Connect the second node back to the first node
            second.next = first;
            
            // Step 3: Connect the previous node to the second node 
            // (which is now the front of this pair)
            prev.next = second;
            
            // Advance the prev pointer to the end of the newly swapped pair
            // (which is the 'first' node) to prep for the next loop
            prev = first;
        }
        
        // Return the new head of the list
        return dummy.next;
    }
}