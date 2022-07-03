package string;

public class C05字符串左翻转 {
    /**
     * 将字符串s 从n开始翻转
     * 例：
     * 输入: s = "abcdefg", k = 2
     * 输出: "cdefgab"
     * 思路一
     * 如果申请额外的辅助空间可以将两个相同的字符串拼接起来 得到abcdefgabcdefg使用字符串截取cdefgab即可
     * return (s+s).substring(n,s.length()+n);
     * 思路二
     * 不使用额外的辅助空间，先将整个字符串翻转，然后再将局部翻转
     * 这种方式在java里面效率其实是不高的，因为还利用到了StringBuilder
     *
     * @param s 原字符串
     * @param n 拼接开始的位置
     * @return
     */
//        return (s+s).substring(n,s.length()+n);  解法一
    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        reverseString(sb, 0, n - 1);
        reverseString(sb, n, len - 1);
        return sb.reverse().toString();
    }

    public void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }
}
