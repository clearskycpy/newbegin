package one_question_a_day.april;

public class C4_21山羊拉丁文 {
    public static void main(String[] args) {
        C4_21山羊拉丁文 c4_21山羊拉丁文 = new C4_21山羊拉丁文();
        System.out.println(c4_21山羊拉丁文.toGoatLatin("I speak Goat Latin"));;
    }
    public String toGoatLatin(String sentence) {
        String[] sArr = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        String s = "a";
        for (int i = 0; i < sArr.length; i++) {
            char c= sArr[i].charAt(0);
            if (c == 'a'|| c == 'e'|| c == 'i'|| c == 'o'|| c == 'u'
                    ||c == 'A'|| c == 'E'|| c == 'I'|| c == 'O'|| c == 'U' ) res.append(sArr[i]+"ma"+s+" ");
            else {

                res.append(sArr[i].substring(1)+c+"ma"+s+" ");
            }
            s = s+"a";
        }
        String ss = res.toString();
        return ss.substring(0,ss.length()-1);
    }
}
