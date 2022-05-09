package random;

import java.util.Scanner;

public class C02构建小对顶 {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int[] arr = createArr();  // 使用方法构建小顶堆
        int min = getMin(arr);
        System.out.println(min);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static int getMin(int[] arr) {
        int res = arr[1];
        arr[1] = arr[arr.length-1];
        arr[arr.length-1] = 0;
        int len = arr.length -1 ;
        int index = 1;
        while(index*2 < len){
            int sun = index*2;
            if (arr[sun+1] <= len && arr[sun+1]< arr[sun]) sun++;
            if (arr[sun] > arr[index]) break;
            int xx = arr[sun];
            arr[sun] = arr[index];
            arr[index]= xx;
            index = sun;
        }
//        返回最小值
        return res;

    }

    public static int[] createArr(){
        int n = scanner.nextInt(); // 获取数据规模
        int[] arr = new int[n + 1];
        int index = 1;
        for (int i = 0; i < n; i++) {
            arr[index] = scanner.nextInt(); // 装填元素
//            构建小顶堆
            int xx = index; // 记录当前位置
            index++;

            while(xx/2 > 0){
                int fu = xx/2;
                if (arr[fu] < arr[xx]) break;
//                否则就交换位置  更新元素位置
                int x = arr[xx];
                arr[xx] = arr[fu];
                arr[fu] = x;
                xx = fu;
            }
        }
        return arr;
    }
}
