package one_question_a_day.july;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class C7_28数组序号转化 {
    /**
     * 输入：arr = [40,10,20,30]
     * 输出：[4,1,2,3]
     * 解释：40 是最大的元素。 10 是最小的元素。 20 是第二小的数字。 30 是第三小的数字。
     *      思路
     *          先将数组排序。如果遇到不同的数就加一
     *
     * @param arr
     * @return
     */
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length  == 0) return new int[0];
        int[] arr1 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = arr[i];
        }
//        对数组进行排序
        Arrays.sort(arr1);
        Map<Integer,Integer> map = new HashMap();
        map.put(arr1[0], 1);
        if (arr1.length >=1){// 这里我们要考虑到到可能存在只有一个元素的情况。所有要做一个if判断
            int index = 2;
            for (int i = 1; i < arr.length; i++) {
                if (arr1[i] != arr1[i-1]){
                    map.put(arr1[i], index);
                    index++;
                }
            }
        }
//        数据装填
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = map.get(arr[i]);
        }
        return arr1;
    }
}
