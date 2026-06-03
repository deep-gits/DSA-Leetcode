/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode t1=list1;
        ListNode t2=list2;
        ListNode dummy= new ListNode(-1);
        ListNode temp=dummy;
        while(t1!=null && t2!=null){
            if(t1.val<=t2.val){
                temp.next=t1;
                t1=t1.next;
            }else{
                temp.next=t2;
                t2=t2.next;
            }
            temp=temp.next;
        }
        if(t1==null) temp.next=t2;
        else temp.next=t1;
        return dummy.next;
    }
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode firsthalf=head;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null &&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode secondhalf=slow.next;
        slow.next=null;
        firsthalf=sortList(firsthalf);
        secondhalf=sortList(secondhalf);
        ListNode ans =merge(firsthalf,secondhalf);
        return ans;
    }
}