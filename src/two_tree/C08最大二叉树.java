package two_tree;

public class C08最大二叉树 {
    /**
     * 最大二叉树的构建
     *      最大值的左边的值构建成左子树，最大值右边的构建成右子树
     *      思路：
     *      使用递归，上述定义其实也是一个递归条件
     *
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums,0, nums.length);  // 包左不包由
    }

    private TreeNode dfs(int[] nums, int leftNode, int rightNode) {
        if (rightNode - leftNode < 1){
            // 说明位置重合了 此时应该返回null即可
            return null;
        }
        if (rightNode - leftNode == 1){
            // 说明此时只剩下一个元素，无论是在左边还是右边。都是直接把这个元素添加进来
            return new TreeNode(nums[leftNode]);
        }
        int max = Integer.MIN_VALUE;
        int center = 0;
        for (int i = leftNode; i < rightNode; i++) {
            if (nums[i] > max){
                max = nums[i];
                center = i;
            }
        }
//        下面这一段是前序遍历
//        因为要先赋值最大的元素，然后再给他的左子树，右子树分别递归下去
        TreeNode treeNode = new TreeNode(max);
        treeNode.left = dfs(nums,leftNode,center);
        // 这里要注意，遵循的是包左不包右的原则，所以这个右边界直接使用中间结点所在位置的索引
        treeNode.right = dfs(nums,center+1,rightNode);
        // 这个位置的左边界就需要注意了。由于左边界是包括的。所以这个地方应该加一，不能重复遍历center的值
        return treeNode;
    }
}
