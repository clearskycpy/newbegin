package Utils;

import one_question_a_day.june.C6_04电子邮件;
import one_question_a_day.may.C5_28消除括号;
import one_question_a_day.may.C5_29有效ip;

public class TestMain {
    public static void main(String[] args) {
//        System.out.println(7^8^9^7^3);
        C5_28消除括号 C = new C5_28消除括号();
        System.out.println(C.deleteKH("(()(()))()()(())"));
        C5_29有效ip c2 = new C5_29有效ip();
        System.out.println(c2.validIPAddress("20EE:FGb8:85a3:0:0:8A2E:0370:7334"));
        C6_04电子邮件 cs = new C6_04电子邮件();
        String[] strings = {"test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"};
        int i = cs.numUniqueEmails(strings);
        System.out.println(i);

    }
}

