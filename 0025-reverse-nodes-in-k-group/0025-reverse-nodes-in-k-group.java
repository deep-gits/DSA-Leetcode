class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupTail = dummy;
        
        while (true) {

            ListNode kthNode = getKthNode(prevGroupTail, k);
            if (kthNode == null) {
                break; 
            }
            

            ListNode nextGroupHead = kthNode.next; 

            ListNode prev = nextGroupHead; 
            ListNode curr = prevGroupTail.next;

            while (curr != nextGroupHead) {
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }

            ListNode newGroupTail = prevGroupTail.next;

            prevGroupTail.next = kthNode;
            prevGroupTail = newGroupTail;
        }
        
        return dummy.next;
    }
    

    private ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}