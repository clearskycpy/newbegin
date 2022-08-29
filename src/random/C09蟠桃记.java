package random;

public class C09蟠桃记 {
    /*表示到了第n天剩下的桃子数为一个。
    * */
    public static int backtracking(int n){
        int count = 1;
        n--;
        while (n != 0){
            count = (count+1)*2;
            n--;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(backtracking(4));
    }

}
