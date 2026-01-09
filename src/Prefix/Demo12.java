package Prefix;


import java.util.Scanner;

//对二维差分进行验证---单点验证
public class Demo12 {
    static int dp[][]=new int[50][50];
    static int d[]=new int[50];
    public static void main1(String[] args) {
        Scanner scan=new Scanner(System.in);
        int[][] arr=new int[][]{{1,5,6,8},{9,6,7,3},{5,3,2,4}};
        for(int i=0;i<2;i++){
            int x1=scan.nextInt();
            int y1=scan.nextInt();
            int x2=scan.nextInt();
            int y2=scan.nextInt();
            int v=scan.nextInt();
            dp[x1][y1]+=v;
            dp[x1][y2+1]-=v;
            dp[x2+1][y1]-=v;
            dp[x2+1][y2+1]+=v;
        }
        for(int i=1;i<=3;i++){
            for(int j=1;j<=4;j++){
               dp[i][j]+=dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1];//对dp数组求和
                arr[i-1][j-1]+=dp[i][j];
            }
        }
        for (int i = 0; i <3; i++) {
            for (int j = 0; j <4; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    //对一维差分进行单点验证
    public static void main(String[] args) {
        int []arr=new int[]{1,2,3,4,5,6,7};
        Scanner scan=new Scanner(System.in);
        int l=scan.nextInt();
        int r=scan.nextInt();
        int v=scan.nextInt();
        d[l]+=v;
        d[r+1]-=v;
        arr[0]+=d[0];
        System.out.print(arr[0]+" ");
        for(int i=1;i<arr.length;i++){
            d[i]+=d[i-1];
            arr[i]+=d[i];
            System.out.print(arr[i]+" ");
        }

    }
}
