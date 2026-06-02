class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        ListNode a=head;
        ListNode b= head;
        while(b!=null){
            if(b.val==a.val) b=b.next;
            else{
                a.next=b;
                a=b;
            }

        }
        a.next=null;
        return head;
    }
}