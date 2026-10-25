class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ListNode curr = head.next;
        int sum = 0;
        
        while (curr != null) {
            if (curr.val == 0) {
                tail.next = new ListNode(sum);
                tail = tail.next;
                sum = 0;
            } else {
                sum += curr.val;
            }
            curr = curr.next;
        }
        
        return dummy.next;
    }
}