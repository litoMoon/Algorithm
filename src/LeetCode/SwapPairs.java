package LeetCode;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode left=head;
        ListNode right=head.next;
        ListNode cur=head;
        left.next=right.next;
        right.next=left;
        head=right;//返回的那个结点
        cur=left;
        if(left.next==null || left.next.next==null) return head;
        right=left.next.next;
        left=left.next;
        while(left!=null && left.next!=null){
            left.next=right.next;
            right.next=left;
            cur.next=right;
            if(left.next==null || left.next.next==null) break;
            right=left.next.next;
            cur=left;
            left=left.next;
        }
        return head;
    }
}
