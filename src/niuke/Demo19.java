package niuke;

import java.util.Scanner;

//平方数
public class Demo19 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long num = in.nextLong();
        double cur = Math.sqrt(num);
        long ret = (long) cur;
        System.out.println(ret * ret);
    }

}
