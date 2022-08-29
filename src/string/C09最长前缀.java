package string;

import java.util.EnumSet;

public class C09最长前缀 {
    /**
     * 先求出前缀数组来。再找到最大的公共前后缀
     * @param s
     * @return
     */
    public String longestPrefix(String s) {
        int[] next = new int[s.length()];
        getNext(next,s);
        int max = -1;
        return s.substring(0,next[s.length()] - 1 );
    }

    private void getNext(int[] next, String s) {
        int j = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i)){
                j = next[j-1];
            }
            if (s.charAt(j) == s.charAt(i)){
                j++;
            }
            next[i] = j;
        }
    }
}
