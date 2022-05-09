package one_question_a_day.may;

import java.util.ArrayList;
import java.util.List;

public class C5_1两个二叉搜索树 {
    /**
     * 二叉搜索树 ： 节点的左子树 小于结点 右子树大于结点
     * @param root1
     * @param root2
     * @return   升序的数组 ： 采用的是中序遍历 左中右
     * 思路 ： 先遍历两个数 得到两个有序的数组 再用归并排序 将两个数组合并
     */
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> nums1 = new ArrayList<>();
        List<Integer> nums2 = new ArrayList<>();
        dfs(nums1,root1);
        dfs(nums2,root2);
        List<Integer> res = new ArrayList<>();
        int index1 = 0,index2 = 0;
        while (true){
            if (index1 == nums1.size()) {
                res.addAll(nums2.subList(index2, nums2.size()));
                break;
            }
            if (index2 == nums2.size()) {
                res.addAll(nums1.subList(index1, nums1.size()));
                break;
            }  // 前面有先遍历完的
            if (nums1.get(index1) < nums2.get(index2)){
                res.add(nums1.get(index1));
                index1++;
            }else {
                res.add(nums2.get(index2));
                index2++;
            }
        }
        return res;
    }

    private void dfs(List<Integer> nums, TreeNode root) {
        if (root == null) return;
        dfs(nums,root.left);
        nums.add(root.val);
        dfs(nums,root.right);
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
