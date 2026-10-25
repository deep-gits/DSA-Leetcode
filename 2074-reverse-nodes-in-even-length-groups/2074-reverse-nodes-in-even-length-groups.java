class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prevGroupEnd = dummy;
        int groupLen = 1;

        while (prevGroupEnd.next != null) {
            ListNode groupStart = prevGroupEnd.next;
            ListNode curr = groupStart;
            int actualLen = 0;

            for (int i = 0; i < groupLen && curr != null; i++) {
                actualLen++;
                curr = curr.next;
            }

            if (actualLen % 2 == 0) {
                ListNode prev = curr;
                ListNode node = groupStart;
                for (int i = 0; i < actualLen; i++) {
                    ListNode nextNode = node.next;
                    node.next = prev;
                    prev = node;
                    node = nextNode;
                }
                prevGroupEnd.next = prev;
                prevGroupEnd = groupStart;
            } else {
                for (int i = 0; i < actualLen; i++) {
                    prevGroupEnd = prevGroupEnd.next;
                }
            }
            groupLen++;
        }

        return dummy.next;
    }
}