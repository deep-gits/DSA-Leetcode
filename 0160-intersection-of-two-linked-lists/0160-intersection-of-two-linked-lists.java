
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=0;
        ListNode tempA=headA;
        while(tempA!=null){
            lenA++;
            tempA=tempA.next;
        }
        int lenB=0;
        ListNode tempB=headB;
        while(tempB!=null){
            lenB++;
            tempB=tempB.next;
        }
        tempA=headA;
        tempB=headB;
        if(lenA>lenB){
            for(int i=0;i<lenA-lenB;i++){
                tempA=tempA.next;
            }
        }else{
            for(int i=0;i<lenB-lenA;i++){
                tempB=tempB.next;
            }
        }
        while(tempA!=tempB){
             tempA=tempA.next;
             tempB=tempB.next;
        }
        return tempB;
    }
}