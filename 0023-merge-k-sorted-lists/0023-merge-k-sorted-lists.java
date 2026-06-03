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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
   public ListNode mergeKLists(ListNode[] lists) {
        // Edge case: if the array is empty
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        int interval = 1;
        
        // Continue merging until the interval covers the entire array
        while (interval < lists.length) {
            for (int i = 0; i + interval < lists.length; i = i + interval * 2) {
                // Merge pairs of lists and store the result in the first index of the pair
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            // Double the interval for the next round (like advancing to the next tournament bracket)
            interval *= 2;
        }
        
        // The final merged list will always end up at index 0
        return lists[0];
    }
}