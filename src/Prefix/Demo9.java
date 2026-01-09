package Prefix;

import java.util.Scanner;

public class Demo9 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();//输入总的树的数目
        int m=scan.nextInt();
        int[]arr=new int[n+1];
        arr[0]=0;
        int sum=0;
        for(int i=1;i<=n;i++) {
            sum+=scan.nextInt();//将每个值进行累加了已经
            arr[i]=sum;
        }
        for(int i=0;i<m;i++) {
            int left=scan.nextInt();
            int right=scan.nextInt();
            System.out.println(arr[right]-arr[left-1]);
        }

    }
}
