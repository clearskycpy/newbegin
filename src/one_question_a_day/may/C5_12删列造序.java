package one_question_a_day.may;

public class C5_12删列造序 {
    public int minDeletionSize(String[] strs) {
        int ans = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            char begin = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (begin <= strs[j].charAt(i)){
                    begin = strs[j].charAt(i);
                }else {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
