class Solution {
    public ListNode doubleIt(ListNode head) {
        int carry = helper(head);
        if (carry > 0) {
            head = new ListNode(carry, head);
        }
        return head;
    }

    private int helper(ListNode node) {
        if (node == null) return 0;
        int carry = helper(node.next);
        int newVal = node.val * 2 + carry;
        node.val = newVal % 10;
        return newVal / 10;
    }
}