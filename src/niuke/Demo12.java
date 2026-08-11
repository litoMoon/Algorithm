package niuke;

import java.util.Scanner;

public class Demo12 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        long sum = 0;//记录最终的结果
        for (int x = 0; x < Math.min(n / 2,m); x++){
            //i 表示 1 号礼包选择的数量
            int y = Math.min((n - 2*x),(m - x) / 2);
            sum = Math.max(x * a,y * b);
        }
        System.out.println(sum);
    }
}
