package two_tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class C01二叉树的层序遍历 {
    /**
     * 层序遍历二叉树 每一层的数放在一个集合里面
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> treeNodes = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()){
            int len = treeNodes.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode poll = treeNodes.poll();
                list.add(poll.val);
                if (poll.left != null) treeNodes.add(poll.left);
                if (poll.right != null) treeNodes.add(poll.right);
            }
            res.add(list);
        }
        return res;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
