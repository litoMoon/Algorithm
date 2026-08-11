package niuke;

import java.util.Scanner;

//笨小猴
public class Demo25 {
    public static boolean isPrim(int num) {
        // 1既不是质数也不是非质数
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int[] chs = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            chs[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (chs[i] != 0) {
                if (max < chs[i]) max = chs[i];
                if (min > chs[i]) min = chs[i];
            }
        }
        int cur = max - min;
        if (!isPrim(cur)) {
            System.out.println("No Answer");
            System.out.println(0);

        } else {
            System.out.println("Lucky Word");
            System.out.println(cur);
        }
    }
}
