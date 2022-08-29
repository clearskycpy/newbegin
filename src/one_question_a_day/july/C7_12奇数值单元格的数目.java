package one_question_a_day.july;

public class C7_12奇数值单元格的数目 {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] result = new int[n][m];
        for (int i = 0; i < indices.length; i++) {
            int row = indices[i][0];
            int cell = indices[i][1];
//            行加一
            for (int j = 0; j < result.length; j++) {
                result[j][row]++;
            }
//            列加一
            for (int j = 0; j < result[0].length; j++) {
                result[cell][j]++;
            }
        }
        int count = 0;
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                if (result[i][j]%2 == 1){
                    count++;
                }
            }
        }
        return count;
    }
}
