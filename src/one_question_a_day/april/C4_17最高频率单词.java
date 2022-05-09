package one_question_a_day.april;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class C4_17最高频率单词 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        for (String b : banned) set.add(b);
        char[] cs = paragraph.toCharArray();
        int n = cs.length;
        String ans = null;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ) {
            if (!Character.isLetter(cs[i]) && ++i >= 0) continue;
            int j = i;
            while (j < n && Character.isLetter(cs[j])) j++;
            String sub = paragraph.substring(i, j).toLowerCase();
            i = j + 1;
            if (set.contains(sub)) continue;
            map.put(sub, map.getOrDefault(sub, 0) + 1);
            if (ans == null || map.get(sub) > map.get(ans)) ans = sub;
        }
        return ans;
    }
}
