package Prefix;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        long []dp=new long[n+1];
        for(int i=1;i<=n;i++){
            long num=in.nextLong();
            dp[i]=dp[i-1]+num;
        }
        for(int i=1;i<=m;i++){
            int p=in.nextInt();
            int q=in.nextInt();
            System.out.println(dp[q]-dp[p-1]);
        }


    }
}
