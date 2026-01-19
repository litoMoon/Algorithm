package LeetCode;

public class ChangeNodes {
    //解题方法 1
    public ListNode swapPairs1(ListNode head) {
        if(head==null || head.next==null ) return head;
        ListNode newHead=swapPairs1(head.next.next);//这里拿到的是4，此时head是3
        ListNode cur=head.next;
        head.next.next=head;
        head.next=newHead;

        return cur;
    }
    //解题方法 2
    public ListNode swapPairs2(ListNode head) {
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

    public static void main(String[] args) {

    }
}
