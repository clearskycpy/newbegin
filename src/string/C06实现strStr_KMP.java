package string;

public class C06实现strStr_KMP {
    /**
     * kmp算法经典题 实现字符串匹配
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int[] next = new int[needle.length()];
        getNext(next,needle);

//        匹配逻辑
        int j = 0; // 这个指向的是模式串的前缀的
        for (int i = 0; i < haystack.length(); i++) { // 遍历字符串
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)){
//                当前位置的字符和模式串的字符不匹配的情况,那么就要找前面一个匹配的前缀的位置，因为之前的后缀是匹配的，
//                所以回退到前一个前缀后缀相等的位置
                j = next[j-1];
            }
            if (haystack.charAt(i) == needle.charAt(j)){
//                此时说明此时又匹配上了，所以j的位置可以再加一
                j++;
            }
            if (j == needle.length()){
//                说明匹配上了此时直接返回位置
                return i - needle.length() + 1;
            }
        }
//        说明没有匹配上这个时候返回-1
        return -1;
    }

    /**
     * 获取前缀数组
     * @param next  未处理的前缀数组
     * @param needle  模式串
     */
    private void getNext(int[] next, String needle) {
//        初始化数组
        next[0] = 0;
        int j = 0;  // 匹配好的前缀的长度（不包括j）
        for (int i = 1; i < needle.length(); i++) {
            // i 实际上表示的是后缀数组的末尾，
            // 细细体会一下，这个位置就是后缀子串尝试匹配成功的最后一个字符
            while (j > 0 && needle.charAt(i) != needle.charAt(j)){
                // 尝试匹配,因为无论是匹配到什么位置，一定是要匹配成功的，就算一直匹配不上 j移动到0 所以采用了一个while循环
                j = next[j-1];
            }
            if (needle.charAt(i) == needle.charAt(j)){
                // 当前位置匹配上了那么j就可以往前移动一位，需要注意的是这个j也有可能是回退过的j，
                // 并不一定是初始的j，但是效果是亦一样的
                j++;
            }
            next[i] = j;
//            那么这个时候就可以录入next数组中匹配到的前后缀长度如果一直没有匹配上，就会移动到0的位置
        }
    }
}
