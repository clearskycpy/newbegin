package one_question_a_day.may;

public class C5_13一次编辑 {
    /**
     * 只编辑一个字符 ，让能够让这两个字符串相同  增删改
     * @param first
     * @param second
     * @return  boolean
     *  当长度差值大于 1 的时候 说明是无法匹配的
     *  当长度差值等于一的时候再使用oneInsert 方法进行判断 是否符合规则
     *  oneInsert方法：
     *          从头遍历两个数组，定义两个指针 如果碰见不一样的情况就只移动一个指针
     *          同时改变一个boolean 类型的值 说明已经修改了一次 ，如果再次遇上两个位置的值不匹配时， 返回false
     *          如果两个位置的值相匹配同时移动两个指针  退出循环的条件是其中的一个指针已经到了字符串的末尾
     */
    public boolean oneEditAway(String first, String second) {
        int m = first.length(), n = second.length();
        if (n - m == 1) {
            return oneInsert(first, second);
        } else if (m - n == 1) {
            return oneInsert(second, first);
        } else if (m == n) {
            boolean foundDifference = false;
            for (int i = 0; i < m; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    if (!foundDifference) {
                        foundDifference = true;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean oneInsert(String shorter, String longer) {
        int length1 = shorter.length(), length2 = longer.length();
        int index1 = 0, index2 = 0;
        while (index1 < length1 && index2 < length2) {
            if (shorter.charAt(index1) == longer.charAt(index2)) {
                index1++;
            }
            index2++;
            if (index2 - index1 > 1) {
                return false;
            }
        }
        return true;
    }

}
