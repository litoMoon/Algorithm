package LeetCode;

public class Binary_search {
    int ret=Integer.MIN_VALUE;
    int count=0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        count=k;
        return ret;
    }
    public void  dfs(TreeNode root){
        if(root==null) return;
        dfs(root.left);
        count--;
        if(count==0) {
            ret=root.val;
            return;
        }
        dfs(root.right);
    }
}

