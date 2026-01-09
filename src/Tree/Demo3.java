package Tree;

import java.util.*;

//求树的宽度
public class Demo3 {
    public static void main(String[] args) {

    }

    public static int widthOfBinaryTree(TreeNode root) {
//        List<Pair<TreeNode, Integer>> q = new ArrayList<>();// 创建一个q用来存储
//        // 题目已知树的节点个数是大于0的
//        q.add(new Pair<TreeNode,Integer>(root, 1));//这个1指代的是下标
//        int ret = 0;
//
//        while (!q.isEmpty()) {
//            // 弹出当前元素的开头与末尾
//            Pair<TreeNode, Integer> cur1 = q.get(0);
//            Pair<TreeNode, Integer> cur2 = q.get(q.size() - 1);
//            // 获取当前行的节点个数,使用max找到最大的
//            ret = Math.max(ret, cur2.getValue() - cur1.getValue() + 1);// 这里是对下标进行的运算
//
//            // 创建一个新的数组来维持新的元素
//            List<Pair<TreeNode, Integer>> tmp = new ArrayList<>();//ArrayList可以动态扩容
//            for (Pair<TreeNode, Integer> m : q) {
//                TreeNode k = m.getKey();
//                int index = m.getValue();
//                // 将当前元素的左右子节点扔进去
//                if (k.left != null)
//                    tmp.add(new Pair(k.left, index * 2));
//                if (k.right != null)
//                    tmp.add(new Pair(k.right, index * 2 + 1));
//            }
//            q = tmp;
//        }
//        return ret;

return 0;
    }
}
class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;

    TreeNode2() {
    }

    TreeNode2(int val) {
        this.val = val;
    }

    TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
