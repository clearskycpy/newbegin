package two_tree;

public class C09合并二叉树 {
    /**
     * 合并两个二叉树也就是对应位置的合并
     * 值合并 和结点合并
     * 值合并需要处理当其中的一个结点为空的时候，就不能直接加上去，
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        TreeNode treeNode = new TreeNode();
        if (root1 != null) {
            treeNode.val += root1.val;
        }
        if (root2 != null){
            treeNode.val += root2.val;
        }
        if (root1 != null && root2 != null) {
            treeNode.left = mergeTrees(root1.left, root2.left);
            treeNode.right = mergeTrees(root1.right, root2.right);
        }
        if (root1 != null && root2 == null) {
            treeNode.left = mergeTrees(root1.left, null);
            treeNode.right = mergeTrees(root1.right, null);
        }
        if (root1 == null && root2 != null) {
            treeNode.left = mergeTrees(null, root2.left);
            treeNode.right = mergeTrees(null, root2.right);
        }
        return treeNode;
    }

}
