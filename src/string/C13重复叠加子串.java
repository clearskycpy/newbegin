package string;

public class C13重复叠加子串 {
    public int repeatedStringMatch(String a, String b) {
        int count = 1;
        String res = a;
        while (!res.contains(b)){
            count++;
            res += a;
        }
        return count;
    }
}
