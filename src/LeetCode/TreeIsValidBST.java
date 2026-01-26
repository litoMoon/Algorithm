package LeetCode;

public class TreeIsValidBST {
    long pre= Long.MIN_VALUE; //设置最小值
/*    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;//空树也是二叉搜索树

        boolean left=isValidBST(root.left);

        //利用剪枝知识
        if(left==false) return false;
        boolean cur=false;
        if(root.val>pre){//由于二叉搜索树的中序遍历一定会是有序的所以后面的值一定会大于前面的值
            cur=true;
        }
        //利用剪枝知识
        if(cur==false) return false;
        pre=root.val;
        boolean right=isValidBST(root.right);

        return left && cur && right;

    }*/
    public boolean isValidBST(TreeNode root) {
        if(root==null ) return true;

        //判断做左子树
        boolean left=isValidBST(root.left);
        if(!left) return false;
        boolean cur=false;

        //判断
        if(root.val>pre){
            cur=true;
        }
        if(!cur) return false;

        //判断右子树
        boolean right=isValidBST(root.right);
        if(!right) return false;

        pre=root.val;
        return left && right && cur;
    }
}
