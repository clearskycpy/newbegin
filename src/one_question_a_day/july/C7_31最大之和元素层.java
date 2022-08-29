package one_question_a_day.july;


import java.util.LinkedList;
import java.util.Queue;

public class C7_31最大之和元素层 {
    /**
     *
     * 求出元素和最大的一层树
     * 如果有两层的和的大小一样，那么就返回小的那一层
     * @param root
     * @return
     */
    public int maxLevelSum(TreeNode root) {
        int maxCell = -1;
        int maxValue = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 0;
        while (!queue.isEmpty()){
            index++;
            int sum = 0;
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode poll = queue.poll();
                sum += poll.val;
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            if (sum > maxValue){
                maxValue = sum;
                maxCell = index;
            }
        }
        return maxCell;
    }

}

