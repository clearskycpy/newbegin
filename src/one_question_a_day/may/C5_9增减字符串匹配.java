package one_question_a_day.may;

public class C5_9增减字符串匹配 {
        public int[] diStringMatch(String s) {
            int n = s.length(), lo = 0, hi = n;  // lo是最小值  hi 是最大值
            int[] perm = new int[n + 1];
//            目标数组
            for (int i = 0; i < n; ++i) {
                perm[i] = s.charAt(i) == 'I' ? lo++ : hi--;
            }
            perm[n] = lo; // 最后剩下一个数，此时 lo == hi
            return perm;
        }


}
