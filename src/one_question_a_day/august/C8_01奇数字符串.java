package one_question_a_day.august;

public class C8_01奇数字符串 {
    /**
     * 生成一个长度为n里面的字符出现的次数为奇数的字符串。
     *      思路：
     *      第一反应就是如何控制好字符出现的频率。如果出现的字母过多是没有办法控制的。这个时候就应该考虑到
     *      题目并没有指出一定要出现多少次哪个字符
     *      只要是奇数就可以
     *      所以我们可以这样推断
     *      如果n是奇数那么我们就添加n个同样的字符，字符随意
     *      如果n是偶数，那么就添加n-1 个同一个字符，，崽添加一个任意字符即可
     *      为了方便调试。我们先添加了n-1个，然后再添加的最后一个，根据情况而定
     * @param n
     * @return
     */
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i =0 ; i < n-1 ; i++){
            sb.append("l");
        }
        if(n % 2 == 0){
            return sb.append("x").toString();
        }else{
            return sb.append("l").toString();
        }
    }
}
