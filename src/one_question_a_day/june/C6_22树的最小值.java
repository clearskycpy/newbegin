package one_question_a_day.june;


/**
 * 找到树的最底层最左的结点的值
 * 思路：
 *      分别用两个变量记录需要返回的值和记录此时最高的高度
 *      然后记得采用后序遍历的方式遍历这个树，保证同一层的情况下一定是最左边的值被保存在resVal中
 *      采用的是深搜的方式。遇到顶点就返回。
 */
public class C6_22树的最小值 {
    int resVal = 0;
    int resHeight = 0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root,0);
        return  resVal;
    }

    private void dfs(TreeNode root, int height) {
        if (root == null){
            return;
        }
        height++;
        dfs(root.left,height);
        dfs(root.right,height);
        if (height>resHeight){
            resHeight = height;
            resVal = root.val;
        }
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
