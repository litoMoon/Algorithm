package niuke;

import java.util.Scanner;

public class Demo32 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long x = in.nextLong();
        int[] arr = new int[20];
        int pos = 0, total = 0, target = 0, sum = 0;
        while (x != 0) {
            int cur = (int)(x % 10);
            sum += cur;
            arr[pos++] = cur;
            x /= 10;
        }
        if (sum % 2 != 0) {
            System.out.println("No");
            return ;
        }
        target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < pos; i++) {
            int num = arr[i];
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        if (dp[target]) System.out.println("Yes");
        else System.out.println("No");
    }
}
