class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode prev = null;
        ListNode curr = slow;
        
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        int maxSum = 0;
        ListNode p1 = head;
        ListNode p2 = prev;
        
        while (p2 != null) {
            int currentSum = p1.val + p2.val;
            maxSum = Math.max(maxSum, currentSum);
            
            
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return maxSum;
    }
}