package niuke;

import java.util.Scanner;
//素数回文
public class Demo34 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long cur = makePrime(n);
        if (isPrime(cur)) System.out.println("prime");
        else System.out.println("noprime");
    }
    public static long makePrime(int num) {
        int[] nums = new int[10];
        int pos = 0;
        StringBuffer sbu = new StringBuffer();
        while (num != 0) {
            nums[pos++] = num % 10;
            num /= 10;
        }
        for (int i = pos - 1; i > 0; i--) {
            sbu.append(nums[i]);
        }
        sbu.append(nums[0]);
        for (int i = 1; i < pos; i++) {
            sbu.append(nums[i]);
        }
        return Long.parseLong(sbu.toString());
    }
    public static boolean isPrime(long num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
