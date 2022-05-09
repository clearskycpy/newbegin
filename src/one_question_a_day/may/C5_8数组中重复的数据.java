package one_question_a_day.may;

import java.util.ArrayList;
import java.util.List;

public class C5_8数组中重复的数据 {
    /**
     * 记录一下数组中出现两次的数组 时间复杂度为 n  空间复杂度为常量  数组里面的数字是1~n
     * 将对应的数字放到对应的位置   由于数组里面是存在重复的数字 所以肯定只有一部分能对应上 当对应的位置不是该数的时候
     * 说明这个数不存在 但是这位置上面的数字出现了两次
     * 【1,2,2,3,4,5，3】
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while(nums[i] != nums[nums[i]-1]){
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - 1 != i){
                list.add(nums[i]);
            }
        }
        return list;
    }

    /**
     *
     * @param nums 目标数组
     * @param i 当前位置元素的下标
     * @param b 要换到的位置的下标
     */
    private void swap(int[] nums, int i, int b) {
        int x = nums[i];
        nums[i] = nums[b];
        nums[b] = x;
    }
}
