package niuke;

import java.util.Arrays;
import java.util.Scanner;

public class Demo17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), index = 3 * n - 2;
        long sum = 0;
        long[] arr = new long[3 * n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextLong();
        }
        Arrays.sort(arr);
        while (n-- > 0 && index > 0) {
            sum += arr[index];
            index -= 2;
        }
        System.out.println(sum);
    }
}
