package niuke;

import java.util.Scanner;
//kotori 和气球
public class Demo27 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int cur = m - 1;
        long sum = m;
        while (--n > 0) {
            sum = sum * cur % 109;
        }
        System.out.println(sum);
    }

}
