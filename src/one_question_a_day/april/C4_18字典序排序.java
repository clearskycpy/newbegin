package one_question_a_day.april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。

        你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。*/
public class C4_18字典序排序 {
    /**
     * 草率的 采用了api排序
     * @param n
     * @return
     */
    public List<Integer> lexicalOrder(int n) {
        String[] ns = new String[n];
        for (int i = 0; i < ns.length; i++) {
            ns[i] = String.valueOf(i+1);
        }
        Arrays.sort(ns);
        List<Integer> ress= new ArrayList<>();
        for (int i = 0; i < ns.length; i++) {
            Integer s = Integer.parseInt(ns[i]);
            ress.add(s);
        }
        return ress;
    }
    public static List<Integer> lexicalOrder2(int n) {
        List<Integer> res = new ArrayList<>();
//        排序应该是 1 ， 10 ，11 ，12 ，13 --- ， 2 ，20 ,21--- 30 31
//        先建立一个for循环 循环1 -- 9 ；
//        在写一个while循环
//        深度优先搜索
        int number = 1;
//        循环添加完所有的数
        for (int i = 1; i <= n; i++) {
            res.add(number);
            System.out.println(number);
            if (number*10 <=  n){
                number *= 10;
            }else {
//                如果大于 那么就回退一位 再加一    回退有两个原因 第一种是超过了 n 第二种是 到了9
//                那么就把末尾的除掉 前面一位再加一数完了1
//                开头再数2不断循环知道结束
                while (number % 10 == 9 || number + 1 > n) {
                    number /= 10;
                }
                number++;
            }
        }
        return res;
    }
}
