package niuke;

import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Demo14 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Set<Integer> set = new HashSet<>();
        ListNode cur1 = pHead1;
        while (cur1 != null){
            set.add(cur1.val);
            cur1 = cur1.next;
        }
        ListNode cur2 = pHead2;
        ListNode ret = null;
        while (cur2 != null){
            if (set.contains(cur2.val)){
                ret = cur2;
                break;
            }
            cur2 = cur2.next;
        }
        return ret;
    }
}
