package string;

public class C02翻转字符2 {
    /**
     * 每2k个字符翻转前k个
     * @param s
     * @param k
     * @return
     */
    StringBuffer res = new StringBuffer();
    public String reverseStr(String s, int k) {
        for (int i = 0; i < s.length(); i += (2*k)) {
            if (i + k < s.length()) {
                reverse(i, i + k, s);
                if ((i+2*k) <= s.length()){
                    res.append(s.substring(i+k,i+2*k));
                }else {
                    res.append(s.substring(i+k));
                }
            }else {
                reverse(i,s.length(),s);
            }
        }
        return res.toString();
    }

    private void reverse(int i, int length, String s) {
        for (int j = length -1; j >= i ; j--) {
            res.append(s.charAt(j));
        }
    }
}
