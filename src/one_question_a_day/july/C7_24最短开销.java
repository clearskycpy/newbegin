package one_question_a_day.july;

public class C7_24最短开销 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        long sum = 0;
        long target = 0;
        int l = Math.min(start,destination);
        int r = Math.max(start,destination);
        for (int i = 0; i < distance.length; i++) {
            sum += distance[i];  // 累积所有的和
            if (i >= l && i < r){
                target += distance[i];
            }
        }
        return (int) Math.min(target,sum-target);
    }
}
