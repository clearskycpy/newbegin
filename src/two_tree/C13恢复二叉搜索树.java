package two_tree;

import java.util.ArrayList;
import java.util.List;

public class C13恢复二叉搜索树 {
    /**
     * 该二叉搜索树中存在两个点的位置发生了交换，导致不是一个完整意义上的二叉搜索树。但是其他方面是一样的
     * 如果使用中序遍历保存找到的值。那么就会得到一个部分有序的序列。唯一一部分不有序的就是交换了位置的两个地方第一个arr[i] > arr[i+1]
     * 说明arr[i] 就是错误的结点
     * 第二个arr[i] > arr[i+1] arr[i+1] 是错误的结点然后再交换这两个结点即可
     *
     * @param root
     */
    List<Integer> res = new ArrayList<>();
    public void recoverTree(TreeNode root) {
        dfs(root); // 得到一个递增序列
        int x = -1;
        int y = -1;
//        交换位置
//        获取到两个错位的数字
        for (int i = 0; i < res.size()-1; i++) {
            if (res.get(i) > res.get(i+1)){
                if (x == -1){
                    x = res.get(i);
                }else {
                    y = res.get(i+1);
                }
            }
        }
        recover(root,2,x,y);
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }
    public void recover(TreeNode root, int count, int x, int y) {
        if (root != null) {
            if (root.val == x || root.val == y) {
                root.val = root.val == x ? y : x;
                if (--count == 0) {
                    return;
                }
            }
            recover(root.right, count, x, y);
            recover(root.left, count, x, y);
        }
    }
}
