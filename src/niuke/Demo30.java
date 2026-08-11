package niuke;

import java.util.Scanner;

public class Demo30 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int num = 0;
        String cur = "";
        while (n-- > 0) {
            num = in.nextInt();
            if (num % 2 == 0) {
                System.out.println(num);
                continue;
            }
            cur = isTrue(num);
            if (cur.equals("-1")) {
                System.out.println(-1);
                continue;
            }
            System.out.println(cur);
        }

    }
    public static String isTrue(int num) {
        int[] arrs = new int[10];
        int pos = 0, index = -1, flag = 0,count = 0;
        StringBuffer sbu = new StringBuffer();
        while (num != 0) {
//            if (num % 10 == 0) {
//                num /= 10;
//                count++;
//                continue;
//            }
            arrs[pos++] = num % 10;
            num /= 10;
        }
        for (int i = 0; i < pos; i++) {
            if (arrs[i] % 2 == 0 && flag == 0) {
                index = i;
                flag = 1;
                continue;
            }
            sbu.append(arrs[i]);
        }
        if(index != -1) sbu.append(arrs[index]);
//        while (count-- > 0) {
//            sbu.append("0");
//        }
        return flag == 0 ? -1 + "" : sbu.toString();
    }
}
