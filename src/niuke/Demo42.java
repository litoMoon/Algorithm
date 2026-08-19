package niuke;

import java.util.Arrays;
import java.util.Scanner;

public class Demo42 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[100010];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int q = in.nextInt();
        int[] curNum = new int[100010];
        int pos = 0;
        while (q-- > 0) {
            int cur = in.nextInt();
            for (int i = pos; i < cur - pos; i++) {
                curNum[pos++] = nums[i];
            }
            Arrays.sort(curNum);
            System.out.println(curNum[curNum.length - 2]);
        }
    }
}
