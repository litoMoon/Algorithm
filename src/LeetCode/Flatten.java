package LeetCode;

public class Flatten {
    TreeNode pre=null;
    public void flatten(TreeNode root) {
        dfs(root);
        root=pre;
    }
    public void dfs(TreeNode root){
        if(root==null) return ;
        dfs(root.right);
        dfs(root.left);

        root.right=pre;
        root.left=null;
        pre=root;
    }
}
