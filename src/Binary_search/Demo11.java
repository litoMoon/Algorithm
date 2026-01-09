package Binary_search;

import java.util.Scanner;

public class Demo11 {
    static int n,k;
    static long []m;
    static long []y;
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        k=scan.nextInt();
        m=new long[n];
        y=new long[n];

        //将值加入数组中
        for(int i=0;i<n;i++){
            m[i]=scan.nextLong();
            y[i]=scan.nextLong();
        }
        long l=0,r=100050;
        while(l<r){
            long mid=(l+r+1)/2;
            if(check(mid)){
                l=mid;
            }else{
                r=mid-1;
            }
        }
        System.out.println(r);
    }
    public static boolean check(long x){
       long tmp=0;
        for(int i=0;i<n;i++){
            tmp+=(m[i]/x)*(y[i]/x);
        }
        return tmp>=k;

    }
}
