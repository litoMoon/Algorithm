package Math;

import java.util.Scanner;

//蓝桥题---质因数分解
public class Demo8 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        long n=scan.nextInt();
        //System.out.println(n/primeOfMax(n));
        System.out.println(primeOfMax(n));
    }
    public static long primeOfMax(long x){
        long ret=0;
        while(x%2==0){
            ret=Math.max(ret,2);
            x/=2;
        }
        for(int i=3;i<=Math.sqrt(x);i+=2){
            while(x%i==0){
                ret=Math.max(ret,i);
                x/=i;
            }
        }
        if(x>2){
            ret=Math.max(ret,x);
        }
        return ret;
    }
}
