package Tree;

//二叉树的锯齿形的层序遍历
import java.util.*;
public class Demo2 {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode1 root) {
        List<List<Integer>> ret=new ArrayList<>();
        if(root==null) return ret;
        Queue<TreeNode1> q=new ArrayDeque<>();//创建队列
        q.offer(root);
        int count=0;
        while(!q.isEmpty()){
            int i=1;
            int size=q.size();//求出长度
            List<Integer> list=new ArrayList<>();//记录每一层节点的个数
            count++;
            for ( ; i <=size; i++) {
                TreeNode1 cur=q.poll();
                list.add(cur.val);
                if(cur.left!=null ) q.add(cur.left);
                if(cur.right!=null) q.add(cur.right);
            }
            if(count%2==0) Collections.reverse(list);
            ret.add(list);

        }
       return ret;
    }

}
class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;

    TreeNode1() {
    }

    TreeNode1(int val) {
        this.val = val;
    }

    TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
