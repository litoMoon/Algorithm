package niuke;

import java.util.Scanner;

public class Demo37 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] ss = str.split("-");
        long sum = 1, ret  = 0;;
        for (int i = 0; i < 3; i++) {
            String s = ss[i];
            int pos = 0, len = s.length();
            while (pos < len) {
                ret += sum * (s.charAt(pos) - '0');
                pos++;
                sum++;
            }
        }

        long cur  = ret % 11;

        if (cur == ss[3].charAt(0) - '0' || (cur == 10 && ss[3].equals("X"))) {
            System.out.println("Right");
        } else {

            //cur != 10 但最后一位是 X
            for (int i = 0; i < 3; i++) {
                System.out.print(ss[i]);
                System.out.print("-");
            }
            ss[3] = cur == 10 ? "X" : cur + "";
            System.out.print(ss[3] + "");
        }
    }
}
