package niuke;

import java.util.Scanner;

public class Demo33 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            long n = in.nextLong();
            long a = in.nextLong();
            long b = in.nextLong();
            long ret = 0, minNum = 0;
            if (n < 2) {
                System.out.println(Math.min(a, b));
                continue;
            }
            if ((3 * a) >= (2 * b)) {
                long cur = n % 3;
                long num = n / 3;
                ret += num * b;
                if (cur == 1) {
                    minNum = Math.min(a, b);
                    minNum = Math.min(minNum, 2 * a - b);
                }
                if (cur == 2) {
                    minNum = Math.min(a, b);
//                     minNum = Math.min(minNum, 2 * a - b);
                }
                ret += minNum;
            } else {
                long cur = n % 2;
                long num = n / 2;
                ret += num * a;
                if (cur == 1) {
                    minNum = Math.min(a, b);
                    minNum = Math.min(minNum, b - a);
                }
                ret += minNum;
            }
            System.out.println(ret);
        }

    }
}
