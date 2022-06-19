package one_question_a_day.june;

import java.util.Random;

public class C6_05长度最小的子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0 ;
        int left = 0;
        int res = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target){
                res = Math.min(right-left+1,res);
                sum -= nums[left];
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? 0:res;
    }
}
