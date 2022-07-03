package one_question_a_day.june;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class C6_24树每层最大值 {
    public List<Integer> largestValues(TreeNode root) {
        Deque<TreeNode> ite = new LinkedList<>();
        ite.add(root);
        List res = new ArrayList();
        while(ite.size() > 0){
//              层序遍历
            int max = Integer.MIN_VALUE;
            int len = ite.size();
            for (int i = 0; i < len; i++) {
                TreeNode temp = ite.pop();
//              取出元素的值
                max = Math.max(max, temp.val);
                if (temp.left != null) ite.add(temp.left);
                if (temp.right != null) ite.add(temp.right);
            }

            res.add(max);
        }
        return res;
    }

}
