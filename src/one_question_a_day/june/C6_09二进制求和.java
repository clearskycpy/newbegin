package one_question_a_day.june;

import java.math.BigDecimal;

public class C6_09二进制求和 {
    public String addBinary(String a, String b) {
//        return Integer.toBinaryString(Integer.parseInt(a,2) + Integer.parseInt(b,2));
//        上面这种用qpi的解法已经不能通过所有的测试用例了

            StringBuffer ans = new StringBuffer();
            // 使用StringBuffer存放结果
            int n = Math.max(a.length(), b.length()), carry = 0;
            // n是相对长的一个二进制数 carry 是存放遍历过程两位相加之和
            for (int i = 0; i < n; ++i) {
                carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
                carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
//                将对应位置的两个数相加
                ans.append((char) (carry % 2 + '0'));   // 和下面同理
                carry /= 2;  // 此时剩余的数除2 往前进位 ，因为是二进制所以除以二，其他进制替换除数即可
            }
            if (carry > 0) {
                ans.append('1');  // 说明最高位还有数 ，并且carry 应该就是 1
            }
            ans.reverse();   // 将二进制数翻转
            return ans.toString();   // 返回结果
    }
}
