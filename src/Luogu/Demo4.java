package Luogu;

import java.util.Scanner;

public class Demo4 {
    static int MOD=123456;
    public static void main(String[] args) {
        int [][]dp=new int[505][505];
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int k=scan.nextInt();
        dp[1][0]=1;//只有一个数，且单调序列为0的个数为1
        for (int i = 2; i <=n; i++) {
            dp[i][0]=2;
            for (int j = 0; j <=i; j++) {
                dp[i+1][j]+=mod(dp[i][j]*(j+1));
                dp[i+1][j+1]+=mod(dp[i][j]*2);
                dp[i+1][j+2]+=mod(dp[i][j]*(i-j-2));
            }
        }
        System.out.println(dp[n][k-1]%MOD);
    }
    public static int mod(int a){
        return a%MOD;
    }
}
