package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class C01组合数 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backTracking(n,1,k);
        return res;
    }

    private void backTracking(int n, int startIndex, int k) {
        if (list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = startIndex; i < n-(k-list.size()); i++) {
            list.add(i);
            backTracking(n,i+1,k);
            list.removeLast();
        }
    }

}
