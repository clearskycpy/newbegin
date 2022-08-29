package one_question_a_day.july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C7_04最小绝对值差 {
    /**
     * 求数组中两数之差最小的所有的两数
     * 例
     * 输入：arr = [4,2,1,3]
     * 输出：[[1,2],[2,3],[3,4]]
     * 示例 2：
     *
     * 输入：arr = [1,3,6,10,15]
     * 输出：[[1,3]]
     * 示例 3：
     *
     * 输入：arr = [3,8,-10,23,19,-4,-14,27]
     * 输出：[[-14,-10],[19,23],[23,27]]
     *
     * @param arr
     * @return
     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min,arr[i] - arr[i-1]);
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i-1] == min){
                List<Integer> nums = new ArrayList<>();
//                题目要求升序排列所以下面添加规则先加前面一个元素再加后面一个元素
                nums.add(arr[i-1]);
                nums.add(arr[i]);
                res.add(nums);
            }
        }
        return res;
    }
}
