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
    public ListNode partition(ListNode head, int x) {
        ListNode a=new ListNode(-1);
        ListNode b=new ListNode(-1);
        ListNode tempa=a;
        ListNode tempb=b;
        ListNode temp=head;
        while(temp!=null){
            if(temp.val<x){
                tempa.next=temp;
                tempa=tempa.next;
            }else{
                tempb.next=temp;
                tempb=tempb.next;
            }
            temp=temp.next;
        }
        tempb.next=null;
        a=a.next;
        b=b.next;
        if(a==null) return b;
        tempa.next=b;
        return a;
    }
}