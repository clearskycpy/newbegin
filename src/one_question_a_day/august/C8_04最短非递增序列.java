package one_question_a_day.august;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C8_04最短非递增序列 {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int target = 0;
        int res = -1;
        for (int i = nums.length-1; i >=0; i--) {
            target += nums[i];
            if (target > sum-target){
                res = i;
                break;
            }
        }
        List<Integer> list = null;
        if(res != -1){
            list = new ArrayList<>();
            for (int i = nums.length-1; i >=res; i--) {
                list.add(nums[i]);
            }
        }
        return list;
    }
}
