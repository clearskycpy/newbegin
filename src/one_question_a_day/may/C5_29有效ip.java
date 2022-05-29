package one_question_a_day.may;

public class C5_29有效ip {
    /**     题目要求
     * 有效的IPv4地址 是 “x1.x2.x3.x4” 形式的IP地址。 其中0 <= xi<= 255且xi不能包含 前导零。例如:“192.168.1.1”、
     * “192.168.1.0” 为有效IPv4地址， “192.168.01.1” 为无效IPv4地址; “192.168.1.00” 、 “192.168@1.1”
     * 为无效IPv4地址。
     *  思路 ：  模拟
     *  将指定ip 转换为 chars 数组 chars
     *  遍历这个数组 ，定义两个指针 （left）一个指向 ip区间的 第一个字符
     *  right （使用for循环变量代替）向左移动 直到碰见 分割符 或者  chars.length 截止
     *  使用方法 isTrue进行判断
     *  循环结束之后再综合判断 是否符合规则
     * @return  res 数组作为返回值
     */
    public String validIPAddress(String queryIP) {
        String[] res = {"IPv4", "IPv6", "Neither"};  // 返回值数组
        char[] chars = queryIP.toCharArray();
        int left = 0;  // 左指针
        int point = 0;  // 点的数量
        if (queryIP.indexOf(".") > 0){
            for (int right = 0; right < chars.length; right++) {
                if (chars[right] == '.'){
//                移动指针
                    if (!isTrue(left,right-1,chars)) return res[2];  // 不满足添加 说明不合法
//                    满足条件 移动指针
                    left = right + 1;
                    point++;  // 点的数量
                }
            }
//            综合判断是否合法
            if (point == 3 && isTrue(left,chars.length-1,chars)) return res[0];
            return res[2];
        }else if (queryIP.indexOf(":") > 0){
            for (int right = 0; right < chars.length; right++) {
                if (chars[right] == ':'){
//                移动指针
                    if (!isTrue2(left,right-1,chars)) return res[2];  // 不满足添加 说明不合法
//                    满足条件 移动指针
                    left = right + 1;
                    point++;
                }
            }
//            综合判断是否合法
            if (point == 7 && isTrue2(left,chars.length-1, chars)) return res[1];
            return res[2];
        }
        return res[2];  // . 或者 ： 出现在第一位
    }

    /**
     * 判断区间内是否符合IPV4
     * @param left
     * @param right
     * @param chars
     * @return
     */
    private boolean isTrue(int left, int right, char[] chars) {
        if (right < left) return false;  // 两个点 挨在一起的情况
        if (right-left == 0 && chars[left] <= '9' && chars[left] >= '0') return true;  // 只有一位数的情况
        if (chars[left] == '0') return false;  // 第一位数是0
        if (right-left > 2) return false;
        int ans = chars[left] - '0';
        for (int i = left+1; i <= right; i++) {
            if(chars[i] > '9') return false;
            ans = ans*10 + (chars[i] - '0');
        }
        if (ans <= 255 ) {
            return true;
        }
        return false;
    }

    private boolean isTrue2(int left, int right, char[] chars) {
        if (right < left) return false;
        if (right - left > 3) return false;
        for (int i = left; i < right+1; i++) {
            if ((chars[i] >= '0' && chars[i] <= '9') || (chars[i] >= 'a' && chars[i] <= 'f') || (chars[i] >= 'A' && chars[i] <= 'F')) {
            }else {
                return false;
            }

        }
        return true;
    }
}
