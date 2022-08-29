package two_tree;

public class C11验证搜索二叉树 {
    /*TreeNode max;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 左
        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }
        // 中
        if (max != null && root.val <= max.val) {
            return false;
        }
        max = root;
        // 右
        boolean right = isValidBST(root.right);
        return right;
    }*/

    /**
     * 下面这个比价好理解
     * 先初始化最小值最小，然后初始化最打值最大
     * if (root.val <= lower || root.val >= upper) return false; 当违背了这个原则的时候那么就返回false
     * 再遍历左右子树即可
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return validBST(Long.MIN_VALUE, Long.MAX_VALUE, root);
    }
    boolean validBST(long lower, long upper, TreeNode root) {
        if (root == null) return true;
        if (root.val <= lower || root.val >= upper) return false;
        return validBST(lower, root.val, root.left) && validBST(root.val, upper, root.right);
    }
}
