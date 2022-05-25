package one_question_a_day.may;

import java.util.*;

public class C5_21寻找长度2n中出现n次的数 {
    public int repeatedNTimes(int[] nums) {
        // 使用map存储
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }
        for (Integer key : map.keySet()){
            if ((map.get(key)-0) == (nums.length/2)){
                return key;
            }
        }
        return -1;
    }

    /**
     * 由于出现了一半多以如果的数组进行排序 最坏的情况就是 【4,4,4,4,4,4,5,5,6,7,8,9】
     * 中间位置的左边或者右边一定是这个数   如果左边等于右边 那么 直接return
     * 如果不等于那么就看第一位元素 是否等于左边的元素 或者最后一位元素是否等于右边一个元素
     * @param nums
     * @return
     */
    public int repeatedNTimes2(int[] nums) {
        int len = nums.length;
        int left = nums.length/2-1;
        int right = nums.length/2;
        Arrays.sort(nums);
        // 左边的元素是
        if (nums[left] == nums[right]){
            return nums[left];
        }else if (nums[0] == nums[left]){
            return nums[left];
        }else if (nums[nums.length-1] == nums[right]){
            return nums[right];
        }
        else {
            return -1;
        }
    }

    /**
     * 这道题说了出现的元素有n+1 个 说明除了那个有一半多的数字出现了n次 其余数字只出现了一次 那么只要找重复出现过的数字就可以了
     * 使用set集合记录出现次数最多的数字
     * @param nums
     * @return
     */
    public int repeatedNTimes3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int a : nums){
            if (!set.add(a)){
                // 添加不成功返回false  取反 说明走这个分支重复出现 直接返回
                return a;
            }
        }
        return -1;
    }
}
