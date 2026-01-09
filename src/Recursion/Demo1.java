package Recursion;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
//求解二叉树的所有路径
public class Demo1 {
    List<String> ret;
    public List<String> binaryTreePaths(TreeNode root) {
        ret=new ArrayList<>();
        dfs(root,new StringBuffer());//由于字符串不可以修改，每次拼接会创建和回收空间不利于效率
        return ret;
    }
    public void dfs(TreeNode root,StringBuffer _path){
        // if(root==null) return; 函数出口
        StringBuffer path=new StringBuffer(_path);
        path.append(Integer.toString(root.val));
        if(root.left==null && root.right==null) {
            ret.add(path.toString());
            return;
        }
        path.append("->");
        //使用剪枝可以优化掉函数出口
        if(root.left!=null) dfs(root.left,path);
        if(root.right!=null) dfs(root.right,path);

    }
}
