package one_question_a_day.august;

public class C8_24子数组翻转 {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] temp = new int[1001];
        for (int i = 0; i < target.length; i++) {
            temp[arr[i]]++;
        }

        for (int i = 0; i < target.length; i++) {
            temp[target[i]]--;
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != 0)
                return false;
        }
        return true;
    }
}
