package niuke;

import java.util.Scanner;

public class Demo21 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int n = in.nextInt(), left = 0, right = n -1, begin = 0, endCount = 0;
        if (n == s.length()) {
            System.out.println(s);
            return ;
        }
        if (n > s.length()) return ;
        while (right < s.length()) {
            int cur = left;
            int count = 0;
            while (cur <= right) {
                if (s.charAt(cur) == 'C' || s.charAt(cur) == 'G') count++;
                cur++;
            }
            if (count > endCount) {
                endCount = count;
                begin = left;
            }
            left++;
            right++;
        }
        System.out.println(s.substring(begin, begin + n));
    }
}
