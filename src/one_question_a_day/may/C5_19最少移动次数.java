package one_question_a_day.may;

import java.util.Arrays;

public class C5_19最少移动次数 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int zhong = nums.length/2;
        int var = nums[zhong];
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > var) {
                ans += (nums[i]-var);
            } else{
                ans += (var - nums[i]);
            }
        }
        return ans;
    }
}
