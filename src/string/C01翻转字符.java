package string;

public class C01翻转字符 {
    public void reverseString(char[] s) {
        int len = s.length-1;
        int index = 0;
        while (index < len){
            char a = s[index];
            s[index] = s[len];
            s[len] = a;
            len--;
            index++;
        }
    }
}
