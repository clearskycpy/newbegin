package two_tree;

import java.util.LinkedList;
import java.util.Queue;

public class C06满二叉树的结点个数 {
    /**
     * 可以使用层序遍历也可以使用递归遍历
     * 只要统计深度即可  满二叉树的结点个数是有规律的
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
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
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            index++;
        }
//        通过完全二叉树的性质可以知道： 结点个数会等于 2的层数次方-1
        return getCount(index)-1;
    }

    /**
     * 这是一个计算二的多少次方的函数
     * @param index
     * @return
     */
    private int getCount(int index) {
        /*if (index == 0) return 1;   这种方式的时间复杂度为n n是index
        return 2*getCount(index-1);*/


        /*下面这种写法看起来时间复杂度降低了 实际是还是n
        因为在递归的时候，依旧是计算了两遍的getCount(index/2) 和直接计算getCount(index) 没有什么区别
        if (index == 0) return 1;
        if (index%2 == 0){
          这个数可以由两个数相乘得到
            return getCount(index/2)*getCount(index/2);
        } else {
            return getCount(index/2)*getCount(index/2)*2;
        }*/

        if (index == 0) return 1;
        int res = getCount(index/2);
        if (index%2 == 0){
//            这个数可以由两个数相乘得到
            return res*res;
        } else {
            return res*res*2;
        }
    }

}
