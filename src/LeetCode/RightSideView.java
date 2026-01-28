package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class RightSideView {
    //二叉树的右视角
    List<Integer> list=new LinkedList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root,0);
        return list;
    }
    public void dfs(TreeNode root,int level){
        if(root==null) return ;
        //list中存储的节点，可以类比为树的层数
        if(level==list.size()) list.add(root.val);
        level++;
        dfs(root.right,level);
        dfs(root.left,level);
    }
}
