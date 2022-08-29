package one_question_a_day.august;

public class C8_29重新排列数组 {
    /**
     * 将原本排列为 x2 x3 x4 x5 y2 y3 y4 y5的数组重新排列为
     * x2 y2 x3 y3 ，，，
     *      思路： 采用双指针的方式，一个从头遍历，一次移动一位。同时每次都进行数据交换
     *      时间复杂度为 O(n) 空间复杂度也是 O(n)
     * @param nums
     * @param n
     * @return
     */
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        int x = 0;
        for (int i = 0; i < n; i++) {
            res[x] = nums[i];
            x++;
            res[x] = nums[i+n];
            x++;
        }
        return res;
    }
}
