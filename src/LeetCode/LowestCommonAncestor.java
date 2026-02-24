package LeetCode;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return root;
        }
        if(root== p || root== q){
            return root;
        }

        TreeNode cur=root;
        TreeNode left=lowestCommonAncestor(cur.left,p,q);
        TreeNode right=lowestCommonAncestor(cur.right,p,q);
        if(left!=null && right!=null){
            return root;
        }
        if(left!=null ){
            return left;
        }else {
            return right;
        }
    }
}
