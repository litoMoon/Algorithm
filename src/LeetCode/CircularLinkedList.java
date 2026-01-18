package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CircularLinkedList {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        Set<ListNode> nodes=new HashSet<>();
        ListNode cur=head;
        while(cur.next!=null){
            if(!nodes.contains(cur)) nodes.add(cur);
            else return cur;
            cur=cur.next;
        }
        return null;
    }
}
