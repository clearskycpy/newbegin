package random;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class C03数据的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);  // 存放元素
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])){
                set.remove(nums2[i]);
                list.add(nums2[i]);
            }
        }
        int[] res = new int[list.size()];
        int i =0 ;
        for (int a :
                list) {
            res[i] = a;
            i++;
        }
        return res;
    }
}
