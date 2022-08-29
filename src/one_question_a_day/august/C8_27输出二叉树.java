package one_question_a_day.august;

import java.util.ArrayList;
import java.util.List;

public class C8_27输出二叉树 {
    public List<List<String>> printTree(TreeNode root) {
        if (root == null) return null;
        int pathLen =  getPath(root);
        List<List<String>> result = new ArrayList<>();

        // 这个采用了位运算的机制。先求出的是树的高度。但是这个树的宽度的大小是 2的n次方减一。
//        如果直接求出2的n次方是比较复杂的，可能还需要写一个递归去实现。这里使用二进制位运算的方式
        int n = (1<<(pathLen+1)) - 1;
        int m = pathLen + 1;
        for (int i = 0; i < m; i++) {
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < n ; j++) {
                temp.add("");
            }
            result.add(temp);
        }
        dfs(result,root,0,(n-1)/2,pathLen);
        return result;
    }

    private void dfs(List<List<String>> result, TreeNode root, int r, int c, int height) {
        result.get(r).set(c,Integer.toString(root.val));
        if (root.left != null) {
            dfs(result, root.left, r + 1, c - (1 << (height - r - 1)), height);
        }
        if (root.right != null) {
            dfs(result, root.right, r + 1, c + (1 << (height - r - 1)), height);
        }
    }
    public int getPath(TreeNode root) {
        int h = 0;
        if (root.left != null) {
//            左树不为空的时候，递归左树和或者h的大小，当h为0 的时候就相当于在头节点的位置。
            h = Math.max(h, getPath(root.left) + 1);
        }
        if (root.right != null) {
//            再递归右树。这个h取值取得是左树和右树的值
            h = Math.max(h, getPath(root.right) + 1);
        }
        return h;
    }
}
