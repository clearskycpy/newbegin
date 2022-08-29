package one_question_a_day.july;

import java.util.HashMap;
import java.util.Map;

public class C7_9最长斐波那契序列 {
    /**
     * 使用了dp 的方式求解
     * @param arr
     * @return
     */
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> indices = new HashMap<Integer, Integer>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            indices.put(arr[i], i);  // 将值和对应位置的索引存进去
        }
        int[][] dp = new int[n][n];  // 表示以 dp[i][j] arr[i] 和 arr[j] 结尾的序列的长度
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // j在前 i在后 。 等于0的时候，里层循环不遍历。 因为没有前项
            // 所以这个遍历是先确定后项，再更新钱项
            for (int j = i - 1; j >= 0 && arr[j] * 2 > arr[i]; j--) {
//                由于三项的关系是逐渐递增的
//                arr[j] * 2 > arr[i] 如果不满足这个的话，意味着取值的时候 第一项会比第二项大。所以也不能循环
//                循环之所以从后往前遍历是为了避免。当从前往后计算值的时候，如果更新了前面的dp，那么就会影响后面的dp的赋值
                int k = indices.getOrDefault(arr[i] - arr[j], -1);
                // 如果存在就获取这个值的索引 。不存在就返回-1
                if (k >= 0) {
                    dp[j][i] = Math.max(dp[k][j] + 1, 3);
                    // 由于这个有前一项，所以要不就在此基础上加一 ，或者说这三个组成一个序列
                }
                ans = Math.max(ans, dp[j][i]);  // 更新最大值
            }
        }
        return ans;
    }
}
