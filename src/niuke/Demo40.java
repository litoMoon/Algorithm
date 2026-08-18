package niuke;

import java.util.ArrayList;
import java.util.Collections;

public class Demo40 {
    public static ListNode1 mergeKLists (ArrayList<ListNode1> lists) {

        ListNode1 ret = new ListNode1(0);
        ListNode1 res = ret;
        ArrayList<Integer> nums = new ArrayList<>();

        for (ListNode1 cur : lists) {
            while (cur != null) {
                nums.add(cur.val);
                cur = cur.next;
            }
        }

        Collections.sort(nums);

        for (int i = 0; i < nums.size(); i++) {
            ListNode1 cur = new ListNode1(nums.get(i));
            ret.next = cur;
            ret = ret.next;
        }

        return res.next;
    }

    public static void main(String[] args) {
        ListNode1 node1 = new ListNode1(1);
        ListNode1 node2 = new ListNode1(2);
        ListNode1 node3 = new ListNode1(3);
        ListNode1 node4 = new ListNode1(4);
        ListNode1 node5 = new ListNode1(5);
        ListNode1 node6 = new ListNode1(6);
        ListNode1 node7 = new ListNode1(7);
//        ListNode1 node8 = new ListNode1(0);
//        ListNode1 node9 = new ListNode1(0);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node5.next = node6;
        node6.next = node7;
        ArrayList<ListNode1> cur = new ArrayList<>();
        cur.add(node1);
        cur.add(node5);
        ListNode1 res = mergeKLists(cur);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

}
class ListNode1 {
   int val;
   ListNode1 next = null;
   public ListNode1(int val) {
     this.val = val;
   }
 }
