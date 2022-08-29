package one_question_a_day.august;

import java.util.Arrays;

public class C8_26数组最大乘积 {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max((nums[nums.length-1]-1)*(nums[nums.length-2]-1),(nums[0] - 1)* (nums[1] -1));
    }
}
