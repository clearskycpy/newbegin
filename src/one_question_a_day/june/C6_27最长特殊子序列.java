package one_question_a_day.june;

public class C6_27最长特殊子序列 {
    /**
     * 双重循环 遍历 而且第二个循环必须也是从0 开始遍历 因为需要判断每一个元素和 其他元素的关系所以需要从0开始遍历
     * 我定义了一个布尔类型状态记录变量chk  如果 只要有一个元素是 str i
     * 的子序列那么就退出循环 同时 改变 chk 也不会更新ans
     * @param strs
     * @return
     */
    public int findLUSlength(String[] strs) {
        int n = strs.length;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            boolean chk =  true;   // 是否成立可以计算子序列 必须j位置上的元素 不存在任何 i 位置上的子序列
            for (int j = 0; j < n; j++) {

                if (i != j && isSubseq(strs[i],strs[j])){
                    // 如果 str i  是 str j 的子序列 就直接退出循环
                    chk = false;
                    break;
                }
            }
            if (chk) {
                ans = Math.max(ans, strs[i].length());
            }
        }
        return ans;
    }

    /**
     * 判断s 是不是t的子序列 如果遍历完t s上面的指针移动到了末尾
     * 说明s里面的元素 t都有 所以s 就是 t 的子序列
     * @param s  str[i]
     * @param t  str[j]
     * @return
     */
    public boolean isSubseq(String s, String t) {
        int ptS = 0, ptT = 0;
        while (ptS < s.length() && ptT < t.length()) {
            if (s.charAt(ptS) == t.charAt(ptT)) {
                ++ptS;
            }
            ++ptT;
        }
        return ptS == s.length();
    }
}
