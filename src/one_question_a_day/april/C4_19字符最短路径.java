package one_question_a_day.april;

import java.util.Arrays;

public class C4_19字符最短路径 {
    /**
     * 采用贪心 。先求得该位置离最近的左边的c的位置 。
     * 再求离最近右边的c位置 取最小值
     * 1 2 3 3 2 1
     * @param s
     * @param c
     * @return
     */
    public int[] shortestToChar(String s, char c) {
        int len = s.length();
        int[] res = new int[len];
        for (int i = 0 ,inx = -len; i < len; i++) {
            if (s.charAt(i) == c){
//                记录出现的c的位置
                inx = i;
            }
            res[i] = i - inx;
        }
//        寻找最近的右边的数
        for (int i = len-1 , inx = 2*len; i >= 0  ; i--) {
            if (s.charAt(i) == c){
                inx = i;
            }
            res[i] = Math.min(res[i],inx - i);
        }
        return res;

    }
}
