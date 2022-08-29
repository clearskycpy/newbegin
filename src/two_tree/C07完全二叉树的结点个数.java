package two_tree;

import java.util.LinkedList;
import java.util.Queue;

public class C07完全二叉树的结点个数 {
    /**
     * 层序遍历
     * 每遍历一个结点就计数一次
     * @param root
     * @return
     */
    public int countNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 0;
        while (!queue.isEmpty()){
            int len = queue.size();
            for (int i = 0; i < len ; i++) {
                TreeNode treeNode = queue.poll();
                index++;
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
        }
        return index;
    }

    /**
     * 递归求解
     * 后序遍历
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftPath = countNodes(root.left);
        int rightPath = countNodes(root.right);
        return leftPath + rightPath + 1;

    }
}
