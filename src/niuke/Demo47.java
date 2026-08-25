package niuke;

import java.util.Scanner;

public class Demo47 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char[] ch = str.toCharArray();
        char[] ss = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            char cur = ss[i];
            int resp = 0;
            for (int j = 0; j < ch.length; j++) {
                int cur2 = Math.abs(ch[j] - cur);
                resp += Math.min(cur2, 26 - cur2);
            }
            ret = Math.min(ret, resp);
        }
        System.out.println(ret);
    }
}
