package LeetCode;

public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre=head;
        if(head.val==val) return head.next;
        if(pre.next==null) return null;
        ListNode cur=head.next;
        while(cur!=null){
            if(cur.val==val) pre.next=cur.next;
            pre=cur;
            cur=cur.next;
        }
        return head;
    }
}
