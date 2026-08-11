package niuke;

import java.util.Scanner;

public class Demo18 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] hash = new long[10001];
        long[] f = new long[10001];
        long[] g = new long[10001];
        f[0] = g[0] =0;
        for (int i = 0; i < n; i++) {
            int cur = in.nextInt();
            hash[cur] += cur;
        }
        for (int i = 1; i <= n; i++) {
            f[i] = g[i - 1] + hash[i];
            g[i] = Math.max(f[i-1], g[i-1]);
        }
        System.out.println(Math.max(f[n], g[n]));
    }
}
