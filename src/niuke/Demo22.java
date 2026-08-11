package niuke;

import java.util.Scanner;

public class Demo22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long h = in.nextLong();
        long b = in.nextLong();
        long k = in.nextLong();
        long sum = 0;//统计小红收到的攻击量
        while(h > 0 && k > 0){
            sum += a;
            sum += b;
            h -= b;
            k -= a;
        }
        if (h <= 0 && k <=0) {
            System.out.println(sum);
            return ;
        } else if (h <= 0 && k > 0) {
            sum += b * 10;
        }else {
            sum += a * 10;
        }
        System.out.println(sum);
    }
}
