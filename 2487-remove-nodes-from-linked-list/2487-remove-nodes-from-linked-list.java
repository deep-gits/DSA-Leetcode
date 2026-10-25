class Solution {
    public ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = removeNodes(head.next);
        return head.val < head.next.val ? head.next : head;
    }
}