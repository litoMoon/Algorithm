package Tree;

import java.sql.Connection;
import java.util.*;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

//N叉树的层序遍历
public class Demo1 {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int nums = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums; i++) {
                Node t = queue.poll();
                list.add(t.val);
                for (Node cur : t.children) {
                    if(cur!=null)
                        queue.add(cur);
                }
//                Collections.addAll(t.children);//这里可以直接写成一次性将所有的 t 的子类的节点一次性装进去
            }
            ret.add(list);
        }
        return ret;
    }
}
