package niuke;

import java.util.Scanner;

//余数保留四位小数
public class Demo49 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        double sum = 1;
        for (int i = n; i >= n - m + 1; i--) sum *= i;
        for (int i = m; i >= 2; i--) sum *= i;
        for (int i = 0; i < m; i++) sum *= 0.8;
        for (int i = 0; i < (n - m); i++) sum *= 0.2;
        System.out.printf("%.4f",sum);
    }
}

