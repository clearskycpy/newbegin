package one_question_a_day.may;

public class C5_9增减字符串匹配 {
    public int[] diStringMatch(String s) {
        int[] res = new int[s.length()+1];
        res[res.length] = 0;
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = n; i >0 ; i--) {
            if(chars[n] == 'I'){
                res[n] = res[n+1] -1;
            }else {
                res[n] = res[n+1] +1;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < res.length; i++) {
            min = Math.min(res[i],min);
        }
        if (min < 0){
            int target = -min;
            for (int i = 0; i < res.length; i++) {
                res[i] += target;
            }
        }
        return res;
    }

}
