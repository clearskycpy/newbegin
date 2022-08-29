package one_question_a_day.august;

public class C8_21单词前缀 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(searchWord) == 0){
                return i+1;
            }
        }
        return -1;
    }
}
