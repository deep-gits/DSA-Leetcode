class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;

        // Check if there are at least k nodes to reverse
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        // If we have k nodes, reverse them
        if (count == k) {
            ListNode reversedHead = reverseKGroup(curr, k); // Recursive call for remaining list
            curr = head;
            
            while (count > 0) {
                ListNode tmp = curr.next;
                curr.next = reversedHead;
                reversedHead = curr;
                curr = tmp;
                count--;
            }
            head = reversedHead;
        }

        return head;
    }
}