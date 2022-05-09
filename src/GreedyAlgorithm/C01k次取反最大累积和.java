package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

/*给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
        选择某个下标 i并将 nums[i] 替换为 -nums[i] 。
        重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
        以这种方式修改数组后，返回数组 可能的最大和 。*/
public class C01k次取反最大累积和 {
    /**
     * 重回idea的第一天
     * 先将数组进行排序。按照绝对值的大小排序。然后从后往前将负数取反
     * 知道把k消耗完。如果所有的负数都取反结束还没有消耗完k
     * 那么就对绝对值最小的一个数进行不断调整直到把k消耗完
     * 难点在于声明一个排序算法
     * 【-4,-3，-2,0,1,3,4,5】
     * @param nums
     * @param k
     * @return
     */
    public int largestSumAfterKNegations(int[] nums, int k) {
//        尝试直接排序
        Arrays.sort(nums);
//        先转换开头
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (k >0 && nums[i] < 0 ){
                nums[i] = -nums[i];
                k--;
                if(i == nums.length-1){ // 如果全都是负数，并且当遍历结束之后k并没有用完时，此时也应该更新最小值的下标
                    index = i;
                }
            }else {
                index = i ; // 这个位置是第一个大于等于0 的位置 或者是k消除完了的位置
                break;
            }
        }
        if (k > 0){
            if (index>= 1 && nums[index] > nums[index -1 ]){
                index--;
            }
            for (int i = k; i >0; i--) {
                nums[index] = -nums[index];
            }
        }
//        遍历结束
        int sum = 0 ;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
