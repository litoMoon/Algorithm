package Prefix;

import java.util.Scanner;

// 二维前缀和
public class Demo2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m=in.nextInt();//行
        int n=in.nextInt();//列
        int p=in.nextInt();//查询次数
        long [][]dp=new long[m+1][n+1];//创建dp表
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1]+in.nextInt()-dp[i-1][j-1];
            }
        }
        while(p>0){
            int x1=in.nextInt();
            int y1=in.nextInt();
            int x2=in.nextInt();
            int y2=in.nextInt();
            if(x1==y1 && y1==x2 && x2==y2) System.out.println(dp[x2][y2]);
                else
                    System.out.println(dp[x2][y2]-dp[x2][y1-1]);
            p--;
        }



    }
}
