package LeetCode;

public class BuildBinaryTree {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        //因为这里需要有的参数为5个，同时又需要使用递归来进行，所以说只能重写一个方法来实现所需要的功能，以便实现函数的调用
        return buildTreeChild(preorder,inorder,0,inorder.length-1);
    }
    public static int preIndex;
    public static TreeNode buildTreeChild(int []preorder,int []inorder,int Inbegin,int Inend){
        if(Inbegin>Inend){
            return null;
        }
         TreeNode root=new TreeNode(preorder[preIndex]);
        int rootIndex=findIndex(inorder,Inbegin,Inend,preorder[preIndex++]);
        root.left=buildTreeChild(preorder,inorder,Inbegin,rootIndex-1);
        root.right=buildTreeChild(preorder,inorder,rootIndex+1,Inend);
        return root;

    }
    //查找每棵树根节点在中序遍历中的位置
    public static int findIndex(int []inorder,int begin,int end,int key){
        for (int i = begin; i <=end; i++) {
            if(inorder[i]==key){
                return i;
            }
        }
        return -1;//如果没有相等的
    }

    public static void main(String[] args) {
    //preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder=new int[]{9,3,15,20,7};
        TreeNode node=buildTree(preorder,inorder);
        while(node!=null){
            //先序遍历节点
        }
    }
}
