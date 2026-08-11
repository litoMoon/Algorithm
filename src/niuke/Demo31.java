package niuke;

class TreeNode {
   int val = 0;
   TreeNode left = null;
   TreeNode right = null;
   public TreeNode(int val) {
     this.val = val;
   }
 }
public class Demo31 {
    public static void main(String[] args) {
        TreeNode cur1 = new TreeNode(-2);
        TreeNode cur2 = new TreeNode(-3);
        TreeNode cur3 = new TreeNode(20);
        TreeNode cur4 = new TreeNode(15);
        TreeNode cur5 = new TreeNode(6);
//        cur3.left = cur4;
//        cur3.right = cur5;
//        cur1.left = cur2;
//        cur1.right = cur3;
        cur1.right = cur2;
        System.out.println(maxPathSum(cur1));
    }
    public static int maxPath = Integer.MIN_VALUE;
    public static int maxPathSum (TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        maxPathSum2(root);
        return maxPath;
    }
    public static int maxPathSum2 (TreeNode root) {
        if (root == null) return 0;
        int leftValue = Math.max(0, maxPathSum2(root.left));
        int rightValue = Math.max(0, maxPathSum2(root.right));
        int cur = root.val + leftValue + rightValue;
        maxPath = Math.max(maxPath, cur);
        return root.val + Math.max(leftValue, rightValue);
    }

}
