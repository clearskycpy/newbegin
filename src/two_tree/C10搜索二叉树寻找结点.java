package two_tree;

public class C10搜索二叉树寻找结点 {
//    寻找结点值为val的结点，没有就返回null；
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (root.val > val) return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }
}
