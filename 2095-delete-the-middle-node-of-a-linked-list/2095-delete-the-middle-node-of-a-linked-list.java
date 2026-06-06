class Solution {
    public ListNode deleteMiddle(ListNode head) {
        // Handle list with 0 or 1 node
        if (head == null || head.next == null) {
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head.next.next;
        
        // Traverse the list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Remove the middle node
        slow.next = slow.next.next;
        
        return head;
    }
}