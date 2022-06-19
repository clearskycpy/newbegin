package one_question_a_day.june;

public class C6_08回旋镖 {
    public boolean isBoomerang(int[][] points) {

        int[] point1 = points[0];
        int[] point2 = points[1];
        int[] point3 = points[2];
        int x1 = point1[0];
        int y1 = point1[1];
        int x2 = point2[0];
        int y2 = point2[1];
        int x = point3[0];
        int y = point3[1];
        int[] i1 = {x1-x2,y1-y2};
        int[] i2 = {x2-x,y2-y};
        return i1[0]*i2[1] -i1[1]*i2[0] != 0;
    }
}
