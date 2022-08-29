package one_question_a_day.august;

public class C8_10求解方程 {
    /**
     * 给出一个方程字符串，是一个一元一次方程，
     *      思路：
     *          模拟我们分别对x 和 常数进行累积。累积之后在遍历减号的左边的时候加就是加减就是减，右边的时候减
     *          变成加，加变成减。每次都取反
     * @param
     * @return
*/    /*public String solveEquation(String equation) {
        int countX = 0;
        int countNum = 0;
//      equation = "x+5-3+x=6+x-2"
        int start = 0;
        int end = -1;

        for (int i = 0; i < equation.length(); i++) {
            if (equation.charAt(i) == '+' || equation.charAt(i) == '-'){

            }

        }
    }*/
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 700; i >= 0 ; i = i -2) {
            stringBuilder.append(i).append(",");
        }
        System.out.println(stringBuilder.toString());
    }
}
