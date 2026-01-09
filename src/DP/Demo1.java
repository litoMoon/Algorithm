package DP;

import java.text.DecimalFormat;
import java.util.*;

//第十四届蓝桥杯Java B组 第四题蜗牛
public class Demo1 {
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 在此输入您的代码...
        int n = scan.nextInt();// 存放竹竿总数
        int[] x = new int[n + 1];// 存放竹竿在x轴的位置
        int[] s = new int[n + 1];// 存放竹竿间的距离，s[3]为第2根竹竿到第3根竹竿的距离
        int[] y_start = new int[n + 1];// 存放竹竿传送门起点在y轴的位置
        int[] y_end = new int[n + 1];// 存放竹竿传送门终点在y轴的位置
        // dp[0][i]表示从起点走到第i根竹竿底部的时间，dp[1][i]表示从起点走到第i根竹竿传送门起点的时间
        double[][] dp = new double[2][n + 1];
        for (int i = 1; i <= n; i++) {
            x[i] = scan.nextInt();
            s[i] = x[i] - x[i - 1];
        }
        for (int i = 1; i < n; i++) {
            y_start[i] = scan.nextInt();
            y_end[i + 1] = scan.nextInt();
        }
        // y_end[1]、dp[1][0]均为不存在的值，初始化为integer的最大值
        y_end[1] = Integer.MAX_VALUE;
        dp[1][0] = Integer.MAX_VALUE;
        // dp算法
        for (int i = 1; i <= n; i++) {
            dp[0][i] = Math.min(dp[0][i - 1] + s[i], dp[1][i - 1] + y_end[i] / 1.3);
            // 当终点在起点上方，向下爬，反之向上爬
            if (y_end[i] > y_start[i]) {
                dp[1][i] = Math.min(dp[0][i] + y_start[i] / 0.7, dp[1][i - 1] + (y_end[i] - y_start[i]) / 1.3);
            } else {
                dp[1][i] = Math.min(dp[0][i] + y_start[i] / 0.7, dp[1][i - 1] + (y_start[i] - y_end[i]) / 0.7);
            }
        }
        // 保留小数点后两位
        // DecimalFormat用于格式化十进制数字。
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(df.format(dp[0][n]));
        scan.close();
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int[] x=new int[n+1];//用来记录每个在x节点的值
        int[] s=new int[n+1];//用于记录每个x节点之间的距离
        int[] y_start=new int[n+1];//用于记录传送门在y轴的起点位置
        int[] y_end=new int[n+1];//用于记录传送门在y轴的终点位置

        double[][] dp=new double[2][n+1];
        for(int i=1;i<=n;i++){
            x[i]=scan.nextInt();
            s[i]=x[i]-x[i-1];//用于记录每个x之间的间隔
        }

        for(int i=1;i<n;i++){
            y_start[i]=scan.nextInt();
            y_end[i+1]=scan.nextInt();

        }
        dp[1][0]=y_end[1]=Integer.MAX_VALUE;
        //使用动态规划开始解题
        for(int i=1;i<=n;i++){

            //到 x 轴上的
            dp[0][i]=Math.min(dp[0][i-1]+s[i],dp[1][i-1]+y_end[i]/1.3);//y_end记录了此时这个杆子的高度，这里/1.3会将整数类型转化为double类型

            //到杆子上的
            if(y_end[i]>y_start[i]){
                dp[1][i]=Math.min(dp[0][i]+y_start[i]/0.7,(y_end[i]-y_start[i])/1.3+dp[1][i-1]);
            }else{
                dp[1][i]=Math.min(dp[0][i]+y_start[i]/0.7,(y_start[i]-y_end[i])/0.7+dp[1][i-1]);
            }

        }

        //结果的输出需要保留两位小数
        //DecimalFormat用于格式化十进制数字。
        DecimalFormat df=new DecimalFormat("#0.00");
        System.out.println(df.format(dp[0][n]));

        scan.close();
    }

}
