class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        Node dummy = new Node(0);
        Node copyCurr = dummy;
        curr = head;

        while (curr != null) {
            Node nextOriginal = curr.next.next;
            copyCurr.next = curr.next;
            curr.next = nextOriginal;
            
            copyCurr = copyCurr.next;
            curr = nextOriginal;
        }

        return dummy.next;
    }
}