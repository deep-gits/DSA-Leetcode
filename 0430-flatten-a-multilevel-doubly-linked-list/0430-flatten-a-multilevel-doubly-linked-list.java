/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) return head;

        Node curr = head;

        while (curr != null) {
            // Case 1: Node has no child -> keep moving right
            if (curr.child == null) {
                curr = curr.next;
                continue;
            }

            // Case 2: Node has a child -> splice child list into current list
            Node childHead = curr.child;
            
            // Find the tail of the child sublist
            Node childTail = childHead;
            while (childTail.next != null) {
                childTail = childTail.next;
            }

            // Connect childTail to curr.next (if curr.next exists)
            if (curr.next != null) {
                childTail.next = curr.next;
                curr.next.prev = childTail;
            }

            // Connect curr to childHead
            curr.next = childHead;
            childHead.prev = curr;

            // Clear child pointer
            curr.child = null;

            // Move to the next node
            curr = curr.next;
        }

        return head;
    }
}