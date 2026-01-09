package Math;

import java.util.Scanner;

public class Demo5 {
    //快速幂
    static long mod;
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        long b=scan.nextLong();
        long p=scan.nextLong();
        mod=scan.nextLong();
        long ret=quickPow(b, p);
        System.out.println(ret);
    }
    public static long quickPow(long b,long p) {
        long ans=1;
        while(p>0) {
            if((p&1)==1){//如果该二进制位存在时
                ans=ans*b%mod;
            }
            b=b*b%mod;
            p>>=1;
        }
        return ans;
    }
}
