package one_question_a_day.june;

import java.util.Arrays;

public class C6_28摆动序列 {
    public void wiggleSort(int[] nums) {
//        现将数组进行排序  【1,4,6,8,9,10】【1,8,4,9,6,10】
//        [1,1,2,1,2,2,1]      [1,1,1,1,2,2,2,2]  [1,3,2,2,3,1] [1,1,2,2,3,3] [4,5,5,6],[5,6,4,5]
        Arrays.sort(nums);
//        使用归并的方式归纳到一个新数组里面，暂时没有想到如何空间优化
        int[] res = new int[nums.length];
        int min = nums.length/2 + nums.length%2 -1;
        int max = nums.length -1;
        for (int i = 0; i < nums.length; i++) {
            if (i%2 == 0){
                res[i] = nums[min];
                min--;
            }else {
                res[i] = nums[max];
                max--;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = res[i];
        }
    }
}
