package two_tree;


public class C02翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        swapTreeNode(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    private void swapTreeNode(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

}
