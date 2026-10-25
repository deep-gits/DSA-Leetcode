class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = head;
        for (int i = 1; i < k; i++) {
            first = first.next;
        }

        ListNode slow = head;
        ListNode fast = first;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        int temp = first.val;
        first.val = slow.val;
        slow.val = temp;

        return head;
    }
}