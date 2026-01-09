package Prefix;

import java.io.*;
import java.util.*;

//棋盘游戏--二维差分前缀和
public class Demo11 {
    static PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));//快速读出模板
    static BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
    static int d[][]=new int[2010][2010];//多开辟
    public static void main(String[] args) throws IOException{
        Scanner scan=new Scanner(System.in);//读入数
        int n=scan.nextInt();
        int m=scan.nextInt();

        //对数组d进行操作
        for(int i=0;i<m;i++){
            int x1=scan.nextInt();
            int y1=scan.nextInt();
            int x2=scan.nextInt();
            int y2=scan.nextInt();
            d[x1][y1]+=1;
            d[x2+1][y1]-=1;
            d[x1][y2+1]-=1;
            d[x2+1][y2+1]+=1;
        }

        //对d数组进行求和
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                d[i][j]+=d[i-1][j]+d[i][j-1]-d[i-1][j-1];
                if(d[i][j]%2==0){
                    System.out.print("0");
                }else{
                    System.out.print("1");
                }
            }
            System.out.println();
        }







    }
}
