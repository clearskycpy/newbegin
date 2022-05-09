package one_question_a_day.april;

public class C4_30最小差值i {
    public int smallestRangeI(int[] nums, int k) {
        if (nums.length == 1) return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min , nums[i]);
            max = Math.max(max,nums[i]);
        }
//        得到的最小差值
        return max-min < (2*k) ? 0 : max-min-(2*k);
    }
}
