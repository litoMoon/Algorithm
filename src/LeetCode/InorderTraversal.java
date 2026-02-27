package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();//List只是一个接口
        if(root==null){
            return list;
        }
        TreeNode cur=root;
        Stack<TreeNode> stack=new Stack<>();
        while(cur!=null || !stack.empty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            list.add(cur.val);
            cur=cur.right;
        }
        return list;
    }
}
