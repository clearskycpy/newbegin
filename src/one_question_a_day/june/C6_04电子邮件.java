package one_question_a_day.june;

import java.util.HashSet;
import java.util.Set;

public class C6_04电子邮件 {
//    遍历每一个字符串将字符串拼接好后存储在set集合当中
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            StringBuilder sb = new StringBuilder();
//            遇到点的话就不拼接上去 ，如果遇见 +号后面的在@之前的所有的数据都不需要进行存储
//            这里我们可以定义一个Boolean类型的变量进行状态的保存
            boolean is = false;
            boolean is2 = false;
            for(char c : emails[i].toCharArray()){
//                遍历每一个字符
//                从头开始遍历
                if (c == '.' && !is2 ) continue;
//                遇到了@符号
                if (c == '@'){
                    is2 = true;
                    sb.append(c);
                    continue;
                }
//                遇到了+号
                if (c == '+'){
                    is = true;
                    continue;
                }
                if (is && !is2) continue; // 加号的后面都不需要
                sb.append(c);
            }
            set.add(sb.toString());
        }
        set.forEach(s -> System.out.println(s));
        return set.size();
    }
}
