package niuke;

import java.util.Scanner;

//神奇的字母二
public class Demo44 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] chars = new int[26];
        int maxCount = 0;
        while (in.hasNext()) {
            String str = in.next();
            for (int i = 0; i < str.length(); i++) {
                int cur = str.charAt(i) - 'a';
                chars[cur]++;
                maxCount = Math.max(maxCount, chars[cur]);
            }
        }
        System.out.println(maxCount);
    }
}
