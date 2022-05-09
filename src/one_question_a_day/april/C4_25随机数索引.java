package one_question_a_day.april;

import java.util.*;

public class C4_25随机数索引 {
    Map<Integer, List<Integer>> pos;  // 使用hash表对数字和下标进行一下映射 。
    Random random;  // 创建一个随机值

    public void Solution(int[] nums) {
        pos = new HashMap<Integer, List<Integer>>();
        random = new Random();
        for (int i = 0; i < nums.length; ++i) {
            pos.putIfAbsent(nums[i], new ArrayList<Integer>());
            pos.get(nums[i]).add(i);
        }
    }
    public int pick(int target) {
        List<Integer> indices = pos.get(target);   // 将获取的list集合随机抽取
        return indices.get(random.nextInt(indices.size()));
    }
}
