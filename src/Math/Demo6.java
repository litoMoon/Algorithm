package Math;

import java.util.Scanner;

public class Demo6 {
    //  gcd模板---求解最大公约数
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        for(int i=0;i<n;i++){
            int a=scan.nextInt();
            int b=scan.nextInt();
            System.out.println(gcd(a,b));
        }
    }
    public static int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}
