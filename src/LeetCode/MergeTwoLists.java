package LeetCode;

//合并两个有序链表
public class MergeTwoLists {
    public ListNode sortList(ListNode head) {
        return toSortList(head, null);
    }

    private ListNode toSortList(ListNode head, ListNode tail) {
        if (head == null) return head;
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        //拆分链表
        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail) {
            fast = fast.next;
            slow = slow.next;
            if (fast != tail) fast = fast.next;
        }
        ListNode mid = slow;//一分为二
        ListNode node1 = toSortList(head, mid);
        ListNode node2 = toSortList(mid, tail);
        //合并链表
        return sort(node1, node2);
    }
    private ListNode sort(ListNode node1, ListNode node2) {
        ListNode ret = new ListNode(0);
        ListNode result=ret;
        ListNode l1 = node1;
        ListNode l2 = node2;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ret.next = l1;
                l1 = l1.next;
            } else {
                ret.next = l2;
                l2 = l2.next;
            }
            ret = ret.next;
        }
        ret.next = l1 == null ? l2 : l1;
        return result.next;
    }
}
