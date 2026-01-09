package Prefix;

import java.util.Scanner;

public class Demo10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        long []sum=new long[n+1];
        int[] arr=new int[n+1];
        sum[0]=0;
        for(int i=1;i<=n;i++) {
            int num=scan.nextInt();
            arr[i]=num;
            sum[i]=sum[i-1]+num;//每次都会读入相应的数
        }
        int ret=0;
        for(int i=1;i<=n-1;i++) {
            ret+=(sum[n]-sum[i])*arr[i];
        }
        System.out.println(ret);


        scan.close();
    }
}
