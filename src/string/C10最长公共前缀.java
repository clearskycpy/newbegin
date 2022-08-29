package string;

import java.util.Arrays;

public class C10最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
//        将数组排序  第一个和最后一个肯定相差最大的，所以只需要比较第一个和最后一个即可
        Arrays.sort(strs);
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < Math.min(strs[0].length(),strs[strs.length-1].length()); i++) {
            if (strs[0].charAt(i) == strs[strs.length-1].charAt(i)) {
                stringBuilder.append(strs[0].charAt(i));
            }else {
                break;
            }
        }
        return stringBuilder.toString();
    }
}
