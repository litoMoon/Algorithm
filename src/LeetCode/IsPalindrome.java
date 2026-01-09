package LeetCode;

public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode fast = head.next;
        ListNode newNode = new ListNode(head.val);//next==null
        int count = 1;//统计总的个数
        while (fast != null) {
            ListNode curNode = new ListNode(fast.val);
            curNode.next = newNode;
            newNode = curNode;
            fast = fast.next;
            count++;
        }
        ListNode left = head;
        ListNode right = newNode;
        count = count / 2;
        while (count-- > 0) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }
}
