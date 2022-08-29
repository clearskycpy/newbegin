package two_tree;

public class C03对称二叉树 {
    /**
     * 判断一个二叉树是否对称，
     * 先比较外层再比较里侧，如果外侧和里侧都是对称的那么说明整个树都是对称的
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return symmetric(root.left,root.right);
    }
    private boolean symmetric(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        } else if (left != null && right == null){
            return false;
        }else if (left == null && right == null){
            return true;
        }else if (left.val != right.val){
            return false;
        }
        boolean is1 = symmetric(left.left,right.right);
        boolean symmetric = symmetric(left.right, right.left);
        return is1&&symmetric;
    }
}
