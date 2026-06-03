class Solution {
    public ListNode oddEvenList(ListNode head) {
        // Edge case: empty list
        if (head == null) {
            return null;
        }
        
        // 1. Create our two dummy nodes and their tail trackers
        ListNode oddDummy = new ListNode(-1);
        ListNode evenDummy = new ListNode(-1);
        
        ListNode oddTail = oddDummy;
        ListNode evenTail = evenDummy;
        
        ListNode curr = head;
        boolean isOdd = true; // Index 1 is odd
        
        // 2. Traverse the list and distribute the nodes
        while (curr != null) {
            if (isOdd) {
                oddTail.next = curr;
                oddTail = oddTail.next;
            } else {
                evenTail.next = curr;
                evenTail = evenTail.next;
            }
            
            curr = curr.next;
            isOdd = !isOdd; // Toggle for the next node
        }
        
        // 3. Connect the odd list to the even list
        oddTail.next = evenDummy.next;
        
        // 4. Terminate the even list to prevent cycles!
        evenTail.next = null;
        
        // Return the true head of the merged list
        return oddDummy.next;
    }
}