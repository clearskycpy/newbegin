package two_tree;

import java.util.LinkedList;
import java.util.Queue;

public class C04二叉树的最大深度 {
    /**
     * 层次遍历
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null ) queue.add(treeNode.left);
                if (treeNode.right != null) queue.add(treeNode.right);
            }
            count++;
        }
        return count;

    }

    /**
     * 递归的方式求解
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if (root == null){
            return 0;
        }
        int x1 = maxDepth2(root.left);
        int x2 = maxDepth2(root.right);
        return 1 + Math.max(x1,x2);
    }
}
