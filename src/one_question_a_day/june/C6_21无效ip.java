package one_question_a_day.june;

public class C6_21无效ip {
    // 使用了java api 中的替换方法 ，如果不使用替换方法的话可以采用遍历的形式，遇到了点就添加[.]
    public String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }

}
