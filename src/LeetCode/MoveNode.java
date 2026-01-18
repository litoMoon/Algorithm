package LeetCode;

public class MoveNode {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null && n==1) return null;
        ListNode cur=head;
        int nodeCount=0;
        while(cur!=null){
            cur=cur.next;
            nodeCount++;
        }
        if (nodeCount == n)
            return head.next;
        int newCount=nodeCount-n;
        cur=head;
        while(--newCount>0){
            cur=cur.next;
        }
        cur.next=null;
        return head;
    }

    public static void main(String[] args) {

    }

}
