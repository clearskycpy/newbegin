package one_question_a_day.june;

public class C6_14对角线遍历 {
//    不是一个正方形，完成对角线遍历
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat.length == 1) return mat[0];
        if (mat[0].length == 1&& mat.length == 2) {
            int[] res = {mat[0][0],mat[1][0]};
            return res;
        }
        int chang = mat[0].length;
        int kuan = mat.length;
        int x1 = 0; // 遍历上面两条边的点
        int y1 = 0;
        int x2 = 0; // 遍历下面两条边的点
        int y2 = 0;
        int[] res = new int[mat.length * mat[0].length];
        int idnex = 0;
        boolean is = false;
        while (true){
            if (is){
                for( int x = x2,y = y2;x<=x1 && y >= y1;x++ , y--){
                    res[idnex] = mat[x][y];
                    idnex++;
                }
                is = !is;
            }else {
                for( int x = x1,y = y1;x>=x2 && y <= y2;x-- , y++){
                    res[idnex] = mat[x][y];
                    idnex++;
                }
                is = !is;
            }
            if (x1 == mat[0].length-1){
                y1++;
            }else {
                x1++;
            }
            if (y2 == mat.length-1){
                x2++;
            }else {
                y2++;
            }
            if ((x1 == x2) && (y1 == y2) && (x1 == mat[0].length - 1)&& (y1 == mat.length-1)) break;
        }
        res[res.length-1] = mat[mat.length -1][mat[0].length -1];
        return  res;
    }
}
