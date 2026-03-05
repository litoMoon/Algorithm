package LeetCode;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricTest(root.left, root.right);
    }

        public boolean isSymmetricTest(TreeNode rootleft, TreeNode rootright){
            if (rootleft == null && rootright != null || rootleft != null && rootright == null) {
                return false;
            }
            if (rootleft == null && rootright == null) {
                return true;
            }
            if (rootleft.val != rootright.val) {
                return false;
            }
            return isSymmetricTest(rootleft.right, rootright.left) &&
                    isSymmetricTest(rootleft.left, rootright.right);

        }
    }

