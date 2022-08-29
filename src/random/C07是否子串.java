package random;

public class C07是否子串 {
    public static void main(String[] args) {
        boolean ac = "abc".contains("a");
        System.out.println(ac);
        System.out.println(isTrue("ABC","BCA"));
    }

    public static boolean isTrue(String s1, String s2){
        s2 += s2;
        return s2.contains(s1);
    }

}
