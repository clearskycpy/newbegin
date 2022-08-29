package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class C02组合总数 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k,0,n,1);
        return res;
    }

    private void backtracking(int k, int sum, int targetSum, int startI) {
//        退出循环的条件
        if (sum > targetSum) return;  // 如果发现相加之和大于目标和，直接退出
        if ((sum == targetSum) && (k == path.size())){
//            和符合并且集合元素个数也符合
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startI; i < 10; i++) {
            path.add(i);
            sum += i;
            backtracking(k,sum,targetSum,i + 1);
//            这个时候，如果上一个递归不成立，那么就应该回溯啦
            path.removeLast();
            sum -= i;
        }
    }
}
