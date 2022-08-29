package string;

public class C12最大重复子串 {
    public int maxRepeating(String sequence, String word) {
        int count =0;
        while (sequence.contains(word)){
            count++;
            word += word;
        }
        return count;
    }
   /* 输入：
            "aaabaaaabaaabaaaabaaaabaaaabaaaaba"
            "aaaba"
    输出：
            3
    预期结果：
            5*/

    public int maxRepeating1(String sequence, String word) {
        int count = 0;
        StringBuilder sb = new StringBuilder(word);
        while(sequence.contains(sb)) {
            count++;
            sb.append(word);
        }
        return count;
    }

}
