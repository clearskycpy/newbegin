package string;

public class C04翻转字符串里面的单词 {
    /**
     * 1先要取出前后空格和中间多余的空格
     * 2在全部翻转
     * 3再将每一个单词翻转
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        StringBuilder stringBuilder = trim(s);
        // 2.反转整个字符串
        reverseString(stringBuilder, 0, stringBuilder.length() - 1);
        // 3.反转各个单词
        reverseEachWord(stringBuilder);
        return stringBuilder.toString();
    }



    private StringBuilder trim(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        return sb;
    }

    public void reverseString(StringBuilder sb, int start, int end) {
        // System.out.println("ReverseWords.reverseString() called with: sb = [" + sb + "], start = [" + start + "], end = [" + end + "]");
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
        // System.out.println("ReverseWords.reverseString returned: sb = [" + sb + "]");
    }

    private void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }
}
