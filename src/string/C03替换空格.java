package string;

public class C03替换空格 {
    public String replaceSpace(String s) {
//        return s.replace(" ","%20"); 使用库函数
//        实际上还可以用数组扩容的方式，从后往前遍历遇到空格就添加%20
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        } // 使用了变长的string
        return sb.toString();
    }

}
