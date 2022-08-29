package two_tree;

public class C05二叉树的最小深度 {
    /**
     * 递归求解
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftPath = minDepth(root.left);
        int rightPath = minDepth(root.right);

        // 如果有一边子树为空，那么就计算另外一边的子树
        if (root.left == null && root.right != null){
            return rightPath + 1;
        }
        if (root.left != null && root.right == null){
            return leftPath + 1;
        }
//        都不为空的时候取最小值
        return Math.min(leftPath,rightPath) +1;

    }
}
