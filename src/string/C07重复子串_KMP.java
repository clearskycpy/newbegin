package string;


public class C07重复子串_KMP {
    /**
     * 利用到了KMP算法
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 0) return false;
        int[] next = new int[s.length()];
        getNext(next,s);
        if (next[next.length-1]!= 0 && next[next.length-1]%(next.length-next[next.length-1]) == 0){
            return true;
        }
        return false;
    }

    private void getNext(int[] next, String s) {
        int j = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j>0 && s.charAt(i) != s.charAt(j)){
                j = next[j-1];
            }
            if (s.charAt(i) == s.charAt(j)){
                j++;
            }
            next[i] = j;
        }
    }
}
