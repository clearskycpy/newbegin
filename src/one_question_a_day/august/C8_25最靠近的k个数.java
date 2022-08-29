package one_question_a_day.august;

import java.util.*;

public class C8_25最靠近的k个数 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
//        找到最接近x的k个数
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i] - x) < min) {
                index = i;
                min = Math.abs(arr[i] - x);
            }

        }
        LinkedList<Integer> list = new LinkedList<>();
        list.add(arr[index]);
        k--;
        int start = index - 1;
        int end = index + 1;
        while (k > 0) {
            if (end >= arr.length || (start >= 0 && Math.abs(arr[start] - x) <= Math.abs(arr[end] - x))) {
                list.addFirst(arr[start]);
                start--;
            } else {
                list.add(arr[end]);
                end++;
            }
            k--;
        }
        return new ArrayList<>(list);
    }
}
