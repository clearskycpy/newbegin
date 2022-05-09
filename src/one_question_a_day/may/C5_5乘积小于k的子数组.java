package one_question_a_day.may;

public class C5_5乘积小于k的子数组 {
    /**
     * 二分查找 的方式
     *
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }
        int n = nums.length;
        double[] logPrefix = new double[n + 1];
        for (int i = 0; i < n; i++) {
            logPrefix[i + 1] = logPrefix[i] + Math.log(nums[i]);
        }
        double logk = Math.log(k);
        int ret = 0;
        for (int j = 0; j < n; j++) {
            int l = 0;
            int r = j + 1;
            int idx = j + 1;
            double val = logPrefix[j + 1] - logk + 1e-10;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (logPrefix[mid] > val) {
                    idx = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            ret += j + 1 - idx;
        }
        return ret;
    }

    /**
     * 划动窗口 解法
     * 定义一个左指针和右指针 每次都移动右指针 同时累积乘积和 如果符合小于k的情况 那么就多了 right-left+1 种组合数
     * 如果不符合条件的话 就while循环移动左指针直到符合要求位置 同时恢复乘积 ans /= nums[left];
     * @param nums  目标数组
     * @param k 目标值
     * @return  组合数
     */
    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        if (k <= 1) return 0;
        int left = 0;   // 左指针
        int right = 0;  // 右指针
        int ans = 1;    // 累积乘积
        int res = 0;    // 组合数
        /*for (int i = 0; i < ; i++) {
            right 指针可能不走 然后走 left指针 所以这个时候需要用while循环
        }*/
        while(right <nums.length){
            ans *= nums[right];
            while (ans >= k){
                ans /= nums[left];
                left++;
            }
            res += right -left +1;
            right++;
        }
        return res;
    }

}
