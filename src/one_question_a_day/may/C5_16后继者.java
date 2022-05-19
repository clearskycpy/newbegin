package one_question_a_day.may;


import java.util.ArrayDeque;
import java.util.Deque;

public class C5_16后继者 {
    public TreeNode2 inorderSuccessor(TreeNode2 root, TreeNode2 p) {
        Deque<TreeNode2> stack = new ArrayDeque<>();
        TreeNode2 curl = root, last = null;
        while (!stack.isEmpty() || curl !=null){
            while(curl != null){
                stack.push(curl);
                curl = curl.left;
            }
            curl = stack.pop();
            if (last == p){
                return curl;
            }
            last = curl;
            curl = curl.right;
        }
        return null;
    }
}
 class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;
    TreeNode2(int x) { val = x; }
}
