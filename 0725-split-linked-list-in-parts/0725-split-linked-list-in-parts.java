class Solution {
    public int length(ListNode head){
        ListNode temp=head;
        int cout=0;
        while(temp!=null){
            temp=temp.next;
            cout++;
        }
        return cout;
    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n=length(head);
        int size=n/k;
        int extra=n%k;
        ListNode[] arr=new ListNode[k];
        int idx=0;
        ListNode temp=head;
        int len=1;
        while(temp!=null){
            int s=size;
            if(extra>0) s++;
            if(len==1) arr[idx++]=temp;
            if(len==s){
                ListNode a=temp.next;
                temp.next=null;
                temp=a;
                len=1;
                extra--;
            }else{
                len++;
                temp=temp.next;
            }
        }
        return arr;
    }
}