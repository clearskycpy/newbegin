package one_question_a_day.august;




import java.util.LinkedList;
import java.util.Queue;

public class C8_05二叉树加层 {
    /**
     * 给定一个二叉树 ，在二叉树的depth层插入一层值为val的结点。
     * 思路：
     *      先使用层序遍历，由于是二叉树所以最多如果有n个结点（下层） 那么插入的结点也是n个。
     *      先将这n个结点保存，在用插入的结点链接起来。
     * @param root
     * @param val
     * @param depth
     * @return
     */
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
//        在结点要加在头结点的情况下
        if (depth == 1) {
            TreeNode ans = new TreeNode(val);
            ans.left = root;
            return ans;
        }
        TreeNode temp = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()){
            count++;
            int len = queue.size();
            if (count == depth-1){  // 遍历到了这一层
                TreeNode treeNode = null;  // 提前定义变量，节省内存开销
                for (int i = 0; i < len; i++) {
                    TreeNode poll = queue.poll();
                    if (poll.left != null) {
                        treeNode =  new TreeNode();
                        treeNode.val = val;
                        // 这两行代码不能互换位置，不然达不到效果
                        treeNode.left = poll.left;
                        poll.left = treeNode;

                    }else {
                        TreeNode treeNode1 = new TreeNode();
                        treeNode1.val = val;
                        poll.left = treeNode1;
                    }
                    if (poll.right != null) {
                        treeNode =  new TreeNode();
                        treeNode.val = val;
                        // 这两行代码不能互换位置，不然达不到效果
                        treeNode.right = poll.right;
                        poll.right = treeNode;
                    }else {
                        TreeNode treeNode1 = new TreeNode();
                        treeNode1.val = val;
                        poll.right = treeNode1;
                    }
                }
                return temp;
            }
            for (int i = 0; i < len; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }

        }
        return null;
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

