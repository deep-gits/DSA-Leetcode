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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start = list1;
        
        // Step 1: Move to the node right before index 'a'
        for (int i = 0; i < a - 1; i++) {
            start = start.next;
        }
        
        // Step 2: Move to the node right after index 'b'
        ListNode end = start;
        for (int i = 0; i < b - a + 2; i++) {
            end = end.next;
        }
        
        // Step 3: Connect the beginning part to list2
        start.next = list2;
        
        // Step 4: Traverse to find the tail of list2
        while (list2.next != null) {
            list2 = list2.next;
        }
        
        // Step 5: Connect the tail of list2 to the remaining part of list1
        list2.next = end;
        
        return list1;
    }
}